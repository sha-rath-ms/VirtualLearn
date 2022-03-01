package com.example.virtualLearning.service;

import com.example.virtualLearning.constants.Constants;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.*;
import com.example.virtualLearning.response.GetTimeStamp;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.MyCourseTable;
import com.example.virtualLearning.tables.VideoStatusTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyCourseService {

    private final MyCourseRepository myCourseRepository;
    private final CourseRepository courseRepository;
    private final ChapterRepository chapterRepository;
    private final ContentRepository contentRepository;
    private final VideoStatusRepository videoStatusRepository;
    private final UserRepository userRepository;

    public List<ResponseAllCourse> getAllMyCourses(Long mobileNumber, Integer page){
        return getListFromId(myCourseRepository.findAllwithMobileNumber(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }

    public void addCourse(Long mobileNumber,Long courseId){
            if(!courseRepository.existsById(courseId)){
                throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
            }
            myCourseRepository.save(new MyCourseTable(mobileNumber,courseId));
    }

    //Method to fetch list of courses from list of courseid
    private List<ResponseAllCourse> getListFromId(List<MyCourseTable> gotCourse) {
        List<Long> idlist = gotCourse.stream().map(MyCourseTable::getCourseId).collect(Collectors.toList());
        List<ResponseAllCourse> courseTables =new ArrayList<ResponseAllCourse>();
        for (Long aLong : idlist) {
            courseTables.add(courseRepository.getById(aLong).responseAllCourse());
        }
        return courseTables;
    }

    public boolean checkIfCourseExists(Long mobileNumber,Long courseId){
        if(!userRepository.existsById(mobileNumber))
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_USER);
        }
        return myCourseRepository.existsByMobileNumberAndCourseId(mobileNumber,courseId).isPresent();
    }

    public List<ResponseAllCourse>  displayCompletedCourses(Long mobileNumber,Integer page){
        return getListFromId(myCourseRepository.findAllCompleted(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }

    public String displayCertificate(Long mobileNumber,Long courseId){
        if(!courseRepository.existsById(courseId)){
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if(!myCourseRepository.findByMobilenumberAndCourseId(mobileNumber,courseId).isCompleted()){
            throw  new CustomExceptions(ResultInfoConstants.COURSE_NOT_COMPLETE);
        }
        return myCourseRepository.getCertificate(mobileNumber,courseId);
    }

    public List<ResponseAllCourse>  displayOngoingCourses(Long mobileNumber,Integer page){
        return getListFromId(myCourseRepository.findAllOngoing(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }

    public void updateCompleted(Long courseId,Long mobileNumber){
        if(!myCourseRepository.existsByMobileNumberAndCourseId(mobileNumber,courseId).isPresent()){
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        MyCourseTable course = myCourseRepository.findByMobilenumberAndCourseId(mobileNumber,courseId);
        course.setCompleted(true);
        course.setCertificateDetails();
        myCourseRepository.save(course);
    }

    public void saveStatus(long userId, long courseId, long chapterId, long contentId, GetTimeStamp getTimeStamp)
    {
        if(!checkIfCourseExists(userId,courseId)){
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if(!courseRepository.existsById(courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        if(!chapterRepository.existsById(chapterId))
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        if(!contentRepository.existsById(contentId))
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CONTENT_ID);
        }
        videoStatusRepository.save(new VideoStatusTable(userId,courseId,chapterId,contentId, getTimeStamp.getTimestamp(), getTimeStamp.isCompleted()));
    }
}
