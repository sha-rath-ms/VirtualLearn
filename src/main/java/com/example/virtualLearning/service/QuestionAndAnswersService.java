package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.QuestionAndAnswers;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.repository.ChapterTestRepository;
import com.example.virtualLearning.repository.QuestionAndAnswersRepository;
import com.example.virtualLearning.response.GetQuestionAndAnswerResponse;
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

    private final MyCourseService myCourseService;

    private final ChapterRepository chapterRepository;

    private final ResultService resultService;

    private final CourseStatus courseStatus;

    private int marks = 0;

    public List<QuestionAndAnswers> getByTestId(long chapterTestId) {
        if(!chapterTestRepository.findById(chapterTestId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_TEST_ID);
        }
        return questionAndAnswersRepository.getByTestId(chapterTestId).stream().map(QuestionAndAnswersTable::questionAndAnswers).collect(Collectors.toList());
    }

    public void save(long userId, long courseId, long chapterId, long chapterTestId, List<GetQuestionAndAnswerResponse> getQuestionAndAnswerResponses)
    {
        if(!myCourseService.checkIfCourseExists(userId, courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.NOT_JOINED);
        }
        if(!chapterRepository.findById(chapterId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        if(!chapterTestRepository.findById(chapterTestId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_TEST_ID);
        }
        getQuestionAndAnswerResponses.forEach((g)->
        {
            if(!questionAndAnswersRepository.existsById(g.getId()))
            {
                throw new CustomExceptions(ResultInfoConstants.INVALID_QUESTION_ID(g.getId()));
            }
            if (questionAndAnswersRepository.findById(g.getId()).get().getAnswer() == g.getAnswer())
            {
                marks++;
            }
        });
        resultService.save(userId,courseId,chapterId,chapterTestId,Integer.parseInt(String.format("%.2f",(marks/ questionAndAnswersRepository.getCount(chapterTestId))*100)));
        if((marks/ questionAndAnswersRepository.getCount(chapterTestId))*100 >= 60 && chapterTestRepository.findById(chapterTestId).get().isFinalTest())
        {
            courseStatus.completedOrNOt(userId,courseId,chapterId);
        }
    }
}
