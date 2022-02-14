package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CourseTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Course {
    private long id;
    @NotNull
    private final String name;
    @NotNull
    private final String imageUrl;
    @NotNull
    private final Category category;
    @NotNull
    private final String subcategory;

    public Course(String name, String imageUrl, Category category, String subcategory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.subcategory = subcategory;
    }

    public CourseTable toCourseTable() {
        return new CourseTable(this.name, this.imageUrl, this.category, this.subcategory);
    }
}
