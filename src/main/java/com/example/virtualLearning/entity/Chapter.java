package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ChapterTable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Chapter {
    private long id;
    @NotNull
    private String name;
    @NotNull
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
