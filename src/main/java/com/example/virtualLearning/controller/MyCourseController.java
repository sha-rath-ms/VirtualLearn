package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.GetTimeStamp;
import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.MyCourseService;
import com.example.virtualLearning.tables.CourseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virtual-learn/my-course")
public class MyCourseController {

    private final MyCourseService myCourseService;

    private final JwtUtility jwtUtility;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<String> add(@RequestHeader("course-id") Long courseId, @RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        myCourseService.addCourse(userId, courseId);
        return new ResponseWrapper<String>(ResultInfoConstants.SUCCESS, null);
    }

    @GetMapping("/display-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<ResponseAllCourse>> displayAll(@RequestHeader("Authorization") String token, @RequestParam(defaultValue = "0") Integer page) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, myCourseService.getAllMyCourses(userId, page));
    }

    @GetMapping("/display-completed")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<ResponseAllCourse>> displayCompleted(@RequestHeader("Authorization") String token, @RequestParam(defaultValue = "0") Integer page) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, myCourseService.displayCompletedCourses(userId, page));
    }

    @GetMapping("/display-ongoing")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<ResponseAllCourse>> displayOngoing(@RequestHeader("Authorization") String token, @RequestParam(defaultValue = "0") Integer page) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, myCourseService.displayOngoingCourses(userId, page));
    }

    @GetMapping("/display-certificate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<String> displayCertificate(@RequestHeader("course-id") Long courseId, @RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));

        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, myCourseService.displayCertificate(userId, courseId));
    }

    //
    @PutMapping("/set-completed")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper setCompletion(@RequestHeader("course-id") Long courseId, @RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        myCourseService.updateCompleted(userId, courseId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PutMapping("/save-status")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper save(@RequestHeader("Authorization") String token, @RequestHeader("course-id") long courseId, @RequestHeader("chapter-id") long chapterId, @RequestHeader("content-id") long contentId, @RequestBody @Valid GetTimeStamp getTimeStamp)
    {
        myCourseService.saveStatus(Long.parseLong(jwtUtility.getUserId(token)),courseId,chapterId,contentId,getTimeStamp);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,null);
    }
}

