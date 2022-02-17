package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ChapterTestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterTestRepository extends JpaRepository<ChapterTestTable, Long> {

    @Query(value = "select * from chapter_test_tbl c where c.chapter_id = :chapterId", nativeQuery = true)
    ChapterTestTable getByChapter(long chapterId);
}
