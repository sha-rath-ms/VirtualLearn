package com.example.virtualLearning.service;

import com.example.virtualLearning.constants.Constants;
import com.example.virtualLearning.repository.CourseRepository;
import com.example.virtualLearning.repository.MyCourseRepository;
import com.example.virtualLearning.tables.CourseTable;
import com.example.virtualLearning.tables.MyCourseTable;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.description.type.TypeList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyCourseService {

    public final MyCourseRepository myCourseRepository;
    public final CourseRepository courseRepository;

    public List<CourseTable> getAllMyCourses(Long mobileNumber, Integer page){
        return getListFromId(myCourseRepository.findAllwithMobileNumber(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }

    public void addCourse(Long mobileNumber,Long courseId){
            myCourseRepository.save(new MyCourseTable(mobileNumber,courseId));
    }

    //Method to fetch list of courses from list of courseid
    //TODO:VERY INEFFICIENT WAY. OPTIMIZE IF POSSIBLE
    private List<CourseTable> getListFromId(List<MyCourseTable> gotCourse) {
        List<Long> idlist = gotCourse.stream().map(MyCourseTable::getCourseId).collect(Collectors.toList());
        List<CourseTable> ct =new ArrayList<CourseTable>();
//        idlist.forEach(i -> {
//            ct.add(courseRepository.getById(i));
//        });
        for (Long aLong : idlist) {
            ct.add(courseRepository.getById(aLong));
        }
        return ct;
    }

    public boolean checkIfCourseExists(Long mobileNumber,Long courseId){
        return myCourseRepository.existsByMobileNumberAndCourseId(mobileNumber,courseId);
    }

    public List<CourseTable>  displayCompletedCourses(Long mobileNumber,Integer page){
        return getListFromId(myCourseRepository.findAllCompleted(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }
    public String displayCertificate(Long mobileNumber,Long courseId){
        return myCourseRepository.getCertificate(mobileNumber,courseId);
    }
    public List<CourseTable>  displayOngoingCourses(Long mobileNumber,Integer page){
        return getListFromId(myCourseRepository.findAllOngoing(mobileNumber,PageRequest.of(page,Constants.pageLimit)));
    }






}