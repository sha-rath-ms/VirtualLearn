package com.example.virtualLearning.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetQuestionAndAnswerResponse {
    private final long id;
    private final int answer;
}
