package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ChapterTable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Chapter {
    private long id;
    @NotNull
    private final String name;
    @NotNull
    private final String imageUrl;

    public Chapter(long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public ChapterTable toChapterTable(long courseId)
    {
        return new ChapterTable(this.name,this.imageUrl,courseId);
    }
}
