package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.ChapterTest;
import com.example.virtualLearning.repository.ChapterTestRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChapterTestService {

    private final ChapterTestRepository chapterTestRepository;

    public ChapterTest getByChapter(long chapterId) {
        return chapterTestRepository.getByChapter(chapterId).toChapterTest();
    }
}
