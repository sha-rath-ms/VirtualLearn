package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ChapterTestTable;
import lombok.Data;

@Data
public class ChapterTest {
    private long id;
    private String name;
    private long chapterId;

    public ChapterTest(long id, String name, long chapterId) {
        this.id = id;
        this.name = name;
        this.chapterId = chapterId;
    }

    public ChapterTestTable toChapterTestTable() {
        return new ChapterTestTable(this.name, this.chapterId);
    }
}
