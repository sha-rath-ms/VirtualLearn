package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Content;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.ChapterRepository;
import com.example.virtualLearning.repository.ContentRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.ContentTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    private final ChapterRepository chapterRepository;

    public List<Content> getByChapter(long chapterId) {
        if(!chapterRepository.findById(chapterId).isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_CHAPTER_ID);
        }
        return contentRepository.getByChapter(chapterId).stream().map(ContentTable::toContent).collect(Collectors.toList());
    }
}
