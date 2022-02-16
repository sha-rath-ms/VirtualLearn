package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Instructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class InstructorTable {
    @Id
    private long id;
    private String name;
    private String imageUrl;
    private String about;

    public InstructorTable(String name, String imageUrl, String about) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.about = about;
    }

    public Instructor toInstructor()
    {
        return new Instructor(this.id,this.name,this.imageUrl,this.about);
    }
}
