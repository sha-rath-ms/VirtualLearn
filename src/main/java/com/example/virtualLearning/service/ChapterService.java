package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Chapter;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.response.ResponseChapterContent;
import com.example.virtualLearning.tables.ChapterTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    private final ContentService contentService;

    private final ChapterTestService chapterTestService;

    public List<Chapter> getAllByCourse(long courseId) {
        return chapterRepository.getAll(courseId).stream().map(ChapterTable::toChapter).collect(Collectors.toList());
    }

    public ResponseChapterContent getChapterContent(long chapterId) {
        return new ResponseChapterContent(contentService.getByChapter(chapterId), chapterTestService.getByChapter(chapterId));
    }
}
