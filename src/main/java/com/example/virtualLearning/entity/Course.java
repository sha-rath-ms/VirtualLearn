package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CourseTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Course {
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String imageUrl;
    @NotNull
    private long categoryId;
    @NotBlank
    private String overview;
    @NotNull
    private String subcategoryId;
    @NotNull
    private long instructorId;
    @NotNull
    @Min(100)
    private int cost;

    public Course(String name, String imageUrl, long categoryId, String overview, String subcategoryId, long instructorId, int cost) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
        this.subcategoryId = subcategoryId;
        this.instructorId = instructorId;
        this.cost = cost;
    }

    public CourseTable toCourseTable() {
        return new CourseTable(this.name, this.imageUrl, this.categoryId, this.overview, this.instructorId, this.cost);
    }

}
