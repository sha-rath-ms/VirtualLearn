package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Course;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course_tbl")

public class CourseTable {
    @Id
    private long id;
    private String name;
    private String imageUrl;
    private long categoryId;
    private String overview;

    public CourseTable(String name, String imageUrl, long categoryId, String overview) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
    }

    public Course toCourse() {
        return new Course(this.id, this.name, this.imageUrl, this.categoryId, this.overview);
    }
}
