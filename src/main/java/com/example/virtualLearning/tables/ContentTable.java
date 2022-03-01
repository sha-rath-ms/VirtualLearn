package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private String videoUrl;
    private Timestamp timestamp;
    @Column(name = "chapter_id")
    private long chapterId;
    private long courseId;

    public ContentTable(String name, String videoUrl, Timestamp timestamp, long chapterId, long courseId) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.timestamp = timestamp;
        this.chapterId = chapterId;
        this.courseId = courseId;
    }

    public Content toContent() {
        return new Content(this.id, this.name, this.videoUrl,this.timestamp, this.chapterId,this.courseId);
    }
}