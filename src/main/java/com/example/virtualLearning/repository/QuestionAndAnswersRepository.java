package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.QuestionAndAnswersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAndAnswersRepository extends JpaRepository<QuestionAndAnswersTable, Long> {

    @Query(value = "select * from quiz_tbl q where q.chapter_test_id = :chapterTestId", nativeQuery = true)
    List<QuestionAndAnswersTable> getByTestId(long chapterTestId);

    @Query(value = "select count(q.id) from quiz_tbl q where q.chapter_test_id =:chapterTestId",nativeQuery = true)
    Integer getCount(long chapterTestId);
}
