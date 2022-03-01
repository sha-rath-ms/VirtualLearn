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
    private long courseId;
    private boolean finalTest;

    public ChapterTestTable(String name, long chapterId, long courseId,boolean finalTest) {
        this.name = name;
        this.chapterId = chapterId;
        this.courseId = courseId;
        this.finalTest= finalTest;
    }

    public ChapterTest toChapterTest() {
        return new ChapterTest(this.id, this.name, this.chapterId,this.courseId);
    }
}
