package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "content_tbl")
@AllArgsConstructor
public class ContentTable {
    @Id
    private long id;
    private String name;
    private String contentUrl;
    private long chapterId;

    public ContentTable(String name, String contentUrl, long chapterId) {
        this.name = name;
        this.contentUrl = contentUrl;
        this.chapterId = chapterId;
    }

    public Content toContent() {
        return new Content(this.id, this.name, this.contentUrl, this.chapterId);
    }
}
