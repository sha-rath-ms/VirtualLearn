package com.example.virtualLearning.exceptions;

import com.example.virtualLearning.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(HandleAllExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseWrapper handleInCorrectPinException(HandleAllExceptions handleAllExceptions) {
        return new ResponseWrapper(handleAllExceptions.getResultInfo(), null);
    }
}