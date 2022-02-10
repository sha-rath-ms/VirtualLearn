package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Chapter;
import lombok.Data;

@Data
public class ChapterTable {
    private long id;
    private String name;
    private String imageUrl;
    private long courseId;

    public ChapterTable(String name, String imageUrl, long courseId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.courseId = courseId;
    }

    public Chapter toChapter()
    {
        return new Chapter(this.id,this.name,this.imageUrl);
    }
}
