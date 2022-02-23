package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ContentTable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Content {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String contentUrl;
    @NotNull
    private long chapterId;

    public Content(long id, String name, String contentUrl, long chapterId) {
        this.id = id;
        this.name = name;
        this.contentUrl = contentUrl;
        this.chapterId = chapterId;
    }

    public ContentTable toContentTable() {
        return new ContentTable(this.name, this.contentUrl, this.chapterId);
    }
}


