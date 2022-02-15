package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.BenefitsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitsRepository extends JpaRepository<BenefitsTable, Long> {

    @Query(value = "select b.message from benefits_tbl b where b.course_id = :courseId", nativeQuery = true)
    List<String> getAll(long courseId);
}