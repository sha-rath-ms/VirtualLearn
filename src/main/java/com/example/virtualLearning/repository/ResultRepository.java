package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ResultTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultTable,Long> {

    @Query(value = "select * from result_tbl r where r.chapterId = :chapterId and r.userId = :userId and r.courseId = :courseId",nativeQuery = true)
    public int getResult(long userId,long courseId,long chapterId);
}
