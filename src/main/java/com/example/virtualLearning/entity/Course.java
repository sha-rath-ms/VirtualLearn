package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.CourseTable;
import lombok.AllArgsConstructor;
import lombok.Data;

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

    private String subcategoryId;
//    private List<Benefits> benefit;
//    private List<Outcomes> outcome;

    public Course(String name, String imageUrl, long categoryId, String overview) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
    }

    public Course(long id, String name, String imageUrl, long categoryId, String overview) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
    }

    public CourseTable toCourseTable() {
        return new CourseTable(this.name, this.imageUrl, this.categoryId, this.overview);
    }

}
