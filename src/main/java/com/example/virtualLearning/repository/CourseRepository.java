package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.CourseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseTable,Long> {
}
