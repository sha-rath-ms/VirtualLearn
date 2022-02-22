package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result_tbl")
@AllArgsConstructor
public class ResultTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "course_id")
    private long courseId;
    @Column(name = "chapter_id")
    private long chapterId;
    private int result;

    public ResultTable(long userId, long courseId, long chapterId, int result) {
        this.userId = userId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.result = result;
    }
}
