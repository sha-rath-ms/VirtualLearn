package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ResultTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultTable,Long> {

    @Query(value = "select * from result_tbl r where r.chapter_id = :chapterId and r.user_id = :userId and r.course_id = :courseId and r.chapter_test_id = :chapterTestId", nativeQuery = true)
    ResultTable getResult(long userId,long courseId,long chapterId,long chapterTestId);

    @Query(value = "select * from result_tbl r where r.user_id = :userId and r.course_id = :courseId and r.result >= 60 ", nativeQuery = true)
    Integer getCountOfPassResult(long userId,long courseId);
}
