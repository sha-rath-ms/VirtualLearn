package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ChapterTable;
import lombok.Data;

@Data
public class Chapter {
    private long id;
    private String name;
    private long courseId;

    public Chapter(long id, String name, long courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    public ChapterTable toChapterTable() {
        return new ChapterTable(this.name, this.courseId);
    }
}
