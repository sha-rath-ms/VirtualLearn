package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Instructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "instructor_tbl")
@NoArgsConstructor
public class InstructorTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "image_url")
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
