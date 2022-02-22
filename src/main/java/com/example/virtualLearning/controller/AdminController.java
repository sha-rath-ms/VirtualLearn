package com.example.virtualLearning.controller;

import com.example.virtualLearning.entity.*;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.AdminService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/virtual-learn/add")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addCourse(@RequestBody @Valid Course course) {
        adminService.insertCourse(course);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addCategory(@RequestBody @Valid Category category) {
        adminService.insertCategory(category);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/chapter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addChapter(@RequestBody @Valid Chapter chapter) {
        adminService.insertChapter(chapter);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/content")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addContent(@RequestBody @Valid Content content) {
        adminService.insertContent(content);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/instructor")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addInstructor(@RequestBody @Valid Instructor instructor) {
        adminService.insertInstructor(instructor);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/chapterTest")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addChapterTest(@RequestBody @Valid ChapterTest chapterTest) {
        adminService.insertChapterTest(chapterTest);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/outcomes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addOutcomes(@RequestBody @Valid Outcomes outcomes) {
        adminService.insertOutcome(outcomes);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/benefits")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addBenefits(@RequestBody @Valid Benefits benefits) {
        adminService.insertBenefits(benefits);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/course-sub")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addCourseSub(@RequestHeader("course-id") long courseId,@RequestHeader("subcategory-id") long subcategoryId) {
        adminService.insertCourseSub(courseId,subcategoryId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @PostMapping("/ads")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper addAds(@RequestHeader("course-id") long courseId) {
        adminService.insertAds(courseId);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }
}
