package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.OutcomesTable;
import com.example.virtualLearning.tables.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<OutcomesTable, Long> {

    @Query(value = "select b.message from outcomes_tbl b where b.course_id = :courseId", nativeQuery = true)
    List<String> getAll(long courseId);
}