package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Chapter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "chapter_tbl")
@NoArgsConstructor
public class ChapterTable {
    @Id
    private long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "course_id")
    private long courseId;

    public ChapterTable(String name, String imageUrl, long courseId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.courseId = courseId;
    }

    public Chapter toChapter()
    {
        return new Chapter(this.id,this.name,this.imageUrl);
    }
}
