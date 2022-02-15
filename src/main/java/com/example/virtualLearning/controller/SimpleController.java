package com.example.virtualLearning.controller;

import com.example.virtualLearning.entity.Users;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfoConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/virtual-learn/dummy")
@Slf4j
@RequiredArgsConstructor
public class SimpleController {
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public String sig() {
        return "Security OK";
    }

}
