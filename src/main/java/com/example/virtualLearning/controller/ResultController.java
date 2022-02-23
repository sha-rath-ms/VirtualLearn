package com.example.virtualLearning.controller;

import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.ResultService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virtual-learn/course/chapter/result")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    private final JwtUtility jwtUtility;

    private final ObjectMapper objectMapper;

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper saveResult(@RequestHeader("Authorization") String token, @RequestHeader("course-id") long courseId, @RequestHeader("chapter-id") long chapterId, @RequestBody int result) {
        resultService.save(Long.parseLong(jwtUtility.getUserId(token)), courseId, chapterId, result);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, null);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Integer> getResult(@RequestHeader("Authorization") String token, @RequestHeader("course-id") long courseId, @RequestHeader("chapter-id") long chapterId) throws JsonProcessingException {

        return new ResponseWrapper(ResultInfoConstants.SUCCESS,objectMapper.writeValueAsString(resultService.getResult(Long.parseLong(jwtUtility.getUserId(token)), courseId, chapterId)));
    }
}
