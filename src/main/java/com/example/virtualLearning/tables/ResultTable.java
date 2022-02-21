package com.example.virtualLearning.tables;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "result_tbl")
@AllArgsConstructor
public class ResultTable {
    @Id
    private long id;
    private long userId;
    private long courseId;
    private long chapterId;
    private int result;

    public ResultTable(long userId, long courseId, long chapterId, int result) {
        this.userId = userId;
        this.courseId = courseId;
        this.chapterId = chapterId;
        this.result = result;
    }
}
