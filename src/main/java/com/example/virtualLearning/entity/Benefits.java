package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.BenefitsTable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Benefits {
    private long id;
    private String message;
    private long courseId;

    public Benefits(String message, long courseId) {
        this.message = message;
        this.courseId = courseId;
    }

    public BenefitsTable toBenefitTable() {
        return new BenefitsTable(this.message, this.courseId);
    }
}
