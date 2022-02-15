package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.OutcomesTable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Outcomes {

    private long id;
    private String message;
    private long courseId;

    public Outcomes(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public OutcomesTable toOutcomesTable() {
        return new OutcomesTable(this.message, this.courseId);
    }
}
