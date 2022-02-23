package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "content_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class ContentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "content_url")
    private String contentUrl;
    @Column(name = "chapter_id")
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