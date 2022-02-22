package com.example.virtualLearning.service;

import com.example.virtualLearning.constants.Constants;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.repository.MyCourseRepository;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.MyCourseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyCourseService {

    public final MyCourseRepository myCourseRepository;
    public final CourseRepository courseRepository;

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
        return myCourseRepository.existsByMobileNumberAndCourseId(mobileNumber,courseId);
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
        if(!myCourseRepository.existsByMobileNumberAndCourseId(mobileNumber,courseId)){
            throw new CustomExceptions(ResultInfoConstants.INVALID_COURSE_ID);
        }
        MyCourseTable course = myCourseRepository.findByMobilenumberAndCourseId(mobileNumber,courseId);
        course.setCompleted(true);
        course.setCertificateDetails();
        myCourseRepository.save(course);
    }

}
