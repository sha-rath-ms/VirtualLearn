package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class VideoStatusTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long courseId;
    private long chapterId;
    private long contentId;
    private Timestamp timestamp;
    private boolean completed;

    public VideoStatusTable(long userId, long courseId, long chapterId, long contentId, Timestamp timestamp, boolean completed) {
        this.userId = userId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.contentId = contentId;
        this.timestamp = timestamp;
        this.completed = completed;
    }
}
