package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class ResultTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "course_id")
    private long courseId;
    @Column(name = "chapter_id")
    private long chapterId;
    @Column(name = "chapter_test_id")
    private long chapterTestId;
    private int result;

    public ResultTable(long userId, long courseId, long chapterId, long chapterTestId, int result) {
        this.userId = userId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.chapterTestId = chapterTestId;
        this.result = result;
    }
}
