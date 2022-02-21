package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.QuestionAndAnswers;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterTestRepository;
import com.example.virtualLearning.repository.QuestionAndAnswersRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.QuestionAndAnswersTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionAndAnswersService {

    private final QuestionAndAnswersRepository questionAndAnswersRepository;

    private final ChapterTestRepository chapterTestRepository;

    public List<QuestionAndAnswers> getByTestId(long chapterTestId) {
        if(!chapterTestRepository.findById(chapterTestId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_TEST_ID);
        }
        return questionAndAnswersRepository.getByTestId(chapterTestId).stream().map(QuestionAndAnswersTable::questionAndAnswers).collect(Collectors.toList());
    }
}
