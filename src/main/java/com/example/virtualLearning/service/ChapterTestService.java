package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.ChapterTest;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.repository.ChapterTestRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChapterTestService {

    private final ChapterTestRepository chapterTestRepository;

    private final ChapterRepository chapterRepository;

    public ChapterTest getByChapter(long chapterId) {
        if(!chapterRepository.findById(chapterId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        return chapterTestRepository.getByChapter(chapterId).toChapterTest();
    }
}
