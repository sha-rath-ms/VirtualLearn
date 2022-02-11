package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.MyCourse;
import lombok.Data;

@Data
public class MyCourseTable {
    private final long userId;
    private final long courseId;

    public MyCourse toMyCourse()
    {
        return new MyCourse(this.userId,this.courseId);
    }
}
