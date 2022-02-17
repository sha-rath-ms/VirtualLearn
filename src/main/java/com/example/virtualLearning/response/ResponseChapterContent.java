package com.example.virtualLearning.response;

import com.example.virtualLearning.entity.ChapterTest;
import com.example.virtualLearning.entity.Content;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponseChapterContent {
    private final List<Content> contents;
    private final ChapterTest chapterTest;
}
