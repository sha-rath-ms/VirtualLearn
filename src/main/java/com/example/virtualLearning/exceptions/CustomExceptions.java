package com.example.virtualLearning.exceptions;

import com.example.virtualLearning.response.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomExceptions extends RuntimeException {
    private ResultInfo resultInfo;
}
