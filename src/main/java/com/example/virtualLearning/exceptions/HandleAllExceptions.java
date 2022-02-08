package com.example.virtualLearning.exceptions;

import com.example.virtualLearning.response.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HandleAllExceptions extends RuntimeException {
    private ResultInfo resultInfo;
}
