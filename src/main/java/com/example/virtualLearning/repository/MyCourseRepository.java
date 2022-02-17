package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.MyCourseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCourseRepository extends JpaRepository<MyCourseTable, Long> {
}