package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CourseTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private long instructorId;
    @NotNull
    @Min(100)
    private int cost;
    @NotNull
    private boolean featured;
    @NotNull
    private boolean beginner;

    public Course(String name, String imageUrl, long categoryId, String overview, long instructorId, int cost, boolean featured, boolean beginner) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
        this.instructorId = instructorId;
        this.cost = cost;
        this.featured = featured;
        this.beginner = beginner;
    }

    public CourseTable toCourseTable() {
        return new CourseTable(this.name, this.imageUrl, this.categoryId, this.overview, this.instructorId, this.cost, this.featured, this.beginner);
    }

}
