package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ContentTable;
import lombok.Data;

@Data
public class Content {
    private long id;
    private String name;
    private String contentUrl;
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


