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
    @NotNull
    private final Category category;

    public Course(long id, String name, String imageUrl, Category category) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public CourseTable toCourseTable()
    {
        return new CourseTable(this.name,this.imageUrl,this.category);
    }
}
