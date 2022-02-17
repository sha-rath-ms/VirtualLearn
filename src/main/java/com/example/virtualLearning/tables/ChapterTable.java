package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Chapter;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "chapter_tbl")
@AllArgsConstructor
public class ChapterTable {
    @Id
    private long id;
    private String name;
    private long courseId;

    public ChapterTable(String name, long courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public Chapter toChapter() {
        return new Chapter(this.id, this.name, this.courseId);
    }
}
