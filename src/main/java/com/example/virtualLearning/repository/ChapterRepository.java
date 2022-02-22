package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ChapterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterTable, Long> {

    @Query(value = "select * from chapter_tbl c where c.course_idd = :courseId", nativeQuery = true)
    List<ChapterTable> getAll(long courseId);
}
