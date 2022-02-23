package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.ChapterTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chapter_test_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class ChapterTestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "chapter_id")
    private long chapterId;

    public ChapterTestTable(String name, long chapterId) {
        this.name = name;
        this.chapterId = chapterId;
    }

    public ChapterTest toChapterTest() {
        return new ChapterTest(this.id, this.name, this.chapterId);
    }
}
