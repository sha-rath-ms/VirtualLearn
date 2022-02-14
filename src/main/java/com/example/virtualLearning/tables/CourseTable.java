package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.entity.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course_tbl")
@NoArgsConstructor
public class CourseTable {
    @Id
    private long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private Category category;
    private String subcategory;

    public CourseTable(String name, String imageUrl, Category category, String subcategory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Course toCourse()
    {
        return new Course(this.id, this.name, this.imageUrl, this.category, this.subcategory);
    }
}
