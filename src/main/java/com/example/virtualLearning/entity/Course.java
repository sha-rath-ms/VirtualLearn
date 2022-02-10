package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CourseTable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Course {
    private long id;
    @NotNull
    private final String name;
    @NotNull
    private final String imageUrl;

    public Course(long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public CourseTable toCourseTable()
    {
        return new CourseTable(this.name,this.imageUrl);
    }
}
