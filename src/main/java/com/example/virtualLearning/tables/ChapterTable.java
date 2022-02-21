package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chapter_tbl")
@AllArgsConstructor
public class ChapterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(name = "course_id")
    private long courseId;

    public ChapterTable(String name, long courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public Chapter toChapter() {
        return new Chapter(this.id, this.name, this.courseId);
    }
}
