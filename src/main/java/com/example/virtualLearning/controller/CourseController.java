package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/virtual-learn")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getAllByCategory(@RequestParam(defaultValue = "0") Integer pageNo, @PathVariable long categoryId) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getAll(pageNo, categoryId));
    }

//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseWrapper getAll(@RequestParam(defaultValue = "0") Integer pageNo) {
//        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getAll(pageNo));
//    }

    @GetMapping("/course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getByCourseById(@PathVariable long courseId) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getById(courseId));
    }
}
