package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ChapterTestTable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ChapterTest {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private long chapterId;
    @NotNull
    private long courseId;
    @NotNull
    private boolean finalTest;

    public ChapterTest(long id, String name, long chapterId, long courseId) {
        this.id = id;
        this.name = name;
        this.chapterId = chapterId;
        this.courseId = courseId;
    }

    public ChapterTestTable toChapterTestTable() {
        return new ChapterTestTable(this.name, this.chapterId,this.courseId,this.finalTest);
    }
}
