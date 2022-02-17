package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Content;
import com.example.virtualLearning.repository.ContentRepository;
import com.example.virtualLearning.tables.ContentTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public List<Content> getByChapter(long chapterId) {
        return contentRepository.getByChapter(chapterId).stream().map(ContentTable::toContent).collect(Collectors.toList());
    }
}
