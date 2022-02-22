package com.example.virtualLearning.controller;

import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.QuestionAndAnswersRepository;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.MyCourseService;
import com.example.virtualLearning.service.QuestionAndAnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virtual-learn/course/chapter/test")
@RequiredArgsConstructor
public class QuizController {

    private final QuestionAndAnswersService questionAndAnswersService;

    private final MyCourseService myCourseService;

    private final JwtUtility jwtUtility;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getTest(@RequestHeader("Authorization") String token,@RequestHeader("course-id") long courseId,@RequestHeader("chapter-test-id") long chapterTestId)
    {
        if(myCourseService.checkIfCourseExists(Long.parseLong(jwtUtility.getUserId(token)), courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.NOT_JOINED);
        }
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,questionAndAnswersService.getByTestId(chapterTestId));
    }
}
