package com.example.virtualLearning.controller;

import com.example.virtualLearning.entity.Chapter;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virtual-learn")
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping("/chapter/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Chapter> getAllByCourse(@PathVariable long courseId) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, chapterService.getAllByCourse(courseId));
    }
}
