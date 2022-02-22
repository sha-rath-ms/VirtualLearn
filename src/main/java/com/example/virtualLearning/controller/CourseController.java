package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseAllCourse;
import com.example.virtualLearning.response.ResponseCourseDetails;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/virtual-learn/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/category/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<ResponseAllCourse>> getAllByCategory(@RequestParam(defaultValue = "0") Integer pageNo, @PathVariable long categoryId) {
        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, courseService.getAllByCategory(pageNo, categoryId));
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getAll(@RequestParam(defaultValue = "0") Integer pageNo) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getAll(pageNo));
    }

    @GetMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseCourseDetails> getByCourseById(@PathVariable long courseId) {
        return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, courseService.getById(courseId));
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseAllCourse> search(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "null") Long categoryId,@RequestBody String courseName)
    {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,courseService.search(courseName,categoryId,pageNo));
    }
}
