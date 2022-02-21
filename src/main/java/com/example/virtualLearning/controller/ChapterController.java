package com.example.virtualLearning.controller;

import com.example.virtualLearning.entity.Chapter;
import com.example.virtualLearning.response.ResponseChapterContent;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virtual-learn/course/chapter")
public class ChapterController {

    private final ChapterService chapterService;

    private final JwtUtility jwtUtility;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Chapter> getAllByCourse(@RequestHeader("course-id") long courseId) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, chapterService.getAllByCourse(courseId));
    }


    //Authenticated
    @GetMapping("/content")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<ResponseChapterContent> getAllByCourse(@RequestHeader("course-id") long courseId, @RequestHeader("chapter-id") long chapterId, @RequestHeader("Authorization") String token) {
        Long userId = Long.parseLong(jwtUtility.getUserId(token));
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, chapterService.getChapterContent(userId,courseId,chapterId));
    }

}
