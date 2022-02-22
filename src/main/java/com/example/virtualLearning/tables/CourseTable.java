package com.example.virtualLearning.tables;

import com.example.virtualLearning.response.ResponseAllCourse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course_tbl")
@NoArgsConstructor

public class CourseTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "category_id")
    private long categoryId;
    private String overview;
    @Column(name = "instructor_id")
    private long instructorId;
    private int cost;
    private boolean featured;
    private boolean beginner;

    public CourseTable(String name, String imageUrl, long categoryId, String overview, long instructorId, int cost, boolean featured, boolean beginner) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.overview = overview;
        this.instructorId = instructorId;
        this.cost = cost;
        this.featured = featured;
        this.beginner = beginner;
    }

    public ResponseAllCourse responseAllCourse() {
        return new ResponseAllCourse(this.id, this.name, this.imageUrl);
    }
}
