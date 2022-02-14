package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Course;
import lombok.Data;

@Data
public class CourseTable {
    private long id;
    private String name;
    private String imageUrl;

    public CourseTable(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Course toCourse()
    {
        return new Course(this.id,this.name,this.imageUrl);
    }
}
