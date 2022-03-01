package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ContentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<ContentTable, Long> {

    @Query(value = "select * from content_tbl c where c.chapter_id = :chapterId", nativeQuery = true)
    List<ContentTable> getByChapter(long chapterId);

    @Query(value = "select count(c.id) from content_tbl c where c.course_id = :courseId", nativeQuery = true)
    Integer getCountOfContents(long courseId);
}
