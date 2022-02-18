package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.CourseService;
import com.example.virtualLearning.service.MyCourseService;
import com.example.virtualLearning.tables.MyCourseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virtual-learn/my-course")
public class MyCourseController {
    private final MyCourseService myCourseService;
    private final JwtUtility jwtUtility;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper add(@RequestHeader("course-id") Long courseId,@RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        myCourseService.addCourse(userId,courseId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }
    @GetMapping("/display-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper displayAll(@RequestHeader("course-id") Long courseId,@RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        myCourseService.addCourse(userId,courseId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }
    @GetMapping("/display-completed")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper displayCompleted(@RequestHeader("course-id") Long courseId,@RequestHeader("Authorization") String token,@RequestHeader("page") Integer page) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        page= page==null?0:page;
        myCourseService.displayCompletedCourses(userId,page);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }
    @GetMapping("/display-ongoing")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper displayOngoing(@RequestHeader("course-id") Long courseId,@RequestHeader("Authorization") String token,@RequestHeader("page") Integer page) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        page= page==null?0:page;
        myCourseService.displayOngoingCourses(userId,page);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }
    @GetMapping("/display-certificate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper displayCertificate(@RequestHeader("course-id") Long courseId,@RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        myCourseService.displayCertificate(userId,courseId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    //TODO Update mycourse request
}

