package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ContentTable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Content {
    private long id;
    @NotNull
    private final String contentUrl;
    @NotNull
    private final boolean completed;

    public Content(long id, String contentUrl, boolean completed) {
        this.id = id;
        this.contentUrl = contentUrl;
        this.completed = completed;
    }

    public ContentTable toContentTable(long chapterId)
    {
        return new ContentTable(this.contentUrl,this.completed,chapterId);
    }
}
