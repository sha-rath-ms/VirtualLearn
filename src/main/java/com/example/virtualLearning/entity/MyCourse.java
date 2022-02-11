package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.MyCourseTable;
import lombok.Data;

@Data
public class MyCourse {
    private final long userId;
    private final long courseId;

    public MyCourseTable toMyCourseTable() {
        return new MyCourseTable(this.userId, this.courseId);
    }
}
