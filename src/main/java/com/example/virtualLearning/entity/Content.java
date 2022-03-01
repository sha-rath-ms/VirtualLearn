package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.ContentTable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Content {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String contentUrl;
    private Timestamp timestamp;
    @NotNull
    private long chapterId;
    @NotNull
    private long courseId;

    public Content(long id, String name, String contentUrl, Timestamp timestamp, long chapterId, long courseId) {
        this.id = id;
        this.name = name;
        this.contentUrl = contentUrl;
        this.timestamp = timestamp;
        this.chapterId = chapterId;
        this.courseId = courseId;
    }

    public ContentTable toContentTable() {
        return new ContentTable(this.name, this.contentUrl, this.timestamp,this.chapterId,this.courseId);
    }
}


