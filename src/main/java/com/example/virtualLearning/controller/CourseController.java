package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.CourseService;
import com.example.virtualLearning.tables.CourseTable;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virtual-learn")
@Slf4j
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/course/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<CourseTable>> getAllCourses(@RequestParam(defaultValue = "0") int pageNo) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getAllCourses(pageNo));
    }

    @GetMapping("/ads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<CourseTable> getAdsById(@PathVariable long id) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.getCourseById(id));
    }

    @GetMapping("/course/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<CourseTable>> search(@RequestBody String courseName, @RequestParam(defaultValue = "0") int pageNo) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, courseService.search(courseName, pageNo));
    }
}
