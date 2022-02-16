package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.InstructorTable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instructor {
    private long id;
    private String name;
    private String imageUrl;
    private String about;

    public Instructor(String name, String imageUrl, String about) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.about = about;
    }

    public InstructorTable toInstructorTable()
    {
        return new InstructorTable(this.name,this.imageUrl,this.about);
    }
}
