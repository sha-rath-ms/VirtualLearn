package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chapter_tbl")
@NoArgsConstructor
public class ChapterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
