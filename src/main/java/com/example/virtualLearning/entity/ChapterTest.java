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

    public ChapterTest(long id, String name, long chapterId) {
        this.id = id;
        this.name = name;
        this.chapterId = chapterId;
    }

    public ChapterTestTable toChapterTestTable() {
        return new ChapterTestTable(this.name, this.chapterId);
    }
}
