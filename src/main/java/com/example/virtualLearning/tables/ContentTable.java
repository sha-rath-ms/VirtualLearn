package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Content;
import lombok.Data;

@Data
public class ContentTable {
    private long id;
    private String contentUrl;
    private boolean completed;
    private long chapterId;

    public ContentTable(String contentUrl, boolean completed, long chapterId) {
        this.contentUrl = contentUrl;
        this.completed = completed;
        this.chapterId = chapterId;
    }

    public Content toContent()
    {
        return new Content(this.id,this.contentUrl,this.completed);
    }
}
