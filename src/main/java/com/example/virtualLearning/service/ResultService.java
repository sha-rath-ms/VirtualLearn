package com.example.virtualLearning.service;

import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.repository.ResultRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.ResultTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    private final MyCourseService myCourseService;

    private final ChapterRepository chapterRepository;

    public void save(long userId,long courseId,long chapterId,long chapterTestId,int result)
    {
        if(!myCourseService.checkIfCourseExists(userId, courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.NOT_JOINED);
        }
        if(!chapterRepository.findById(chapterId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        resultRepository.save(new ResultTable(userId,courseId,chapterId,chapterTestId,result));
    }

    public int getResult(long userId,long courseId,long chapterId,long chapterTestId)
    {
        if(!myCourseService.checkIfCourseExists(userId, courseId))
        {
            throw new CustomExceptions(ResultInfoConstants.NOT_JOINED);
        }
        if(!chapterRepository.findById(chapterId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        return resultRepository.getResult(userId,courseId,chapterId,chapterTestId).getResult();
    }
}
