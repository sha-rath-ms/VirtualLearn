package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.QuestionAndAnswers;
import com.example.virtualLearning.repository.QuestionAndAnswersRepository;
import com.example.virtualLearning.tables.QuestionAndAnswersTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionAndAnswersService {

    private final QuestionAndAnswersRepository questionAndAnswersRepository;

    public List<QuestionAndAnswers> getByTestId(long chapterTestId) {
        return questionAndAnswersRepository.getByTestId(chapterTestId).stream().map(QuestionAndAnswersTable::questionAndAnswers).collect(Collectors.toList());
    }
}
