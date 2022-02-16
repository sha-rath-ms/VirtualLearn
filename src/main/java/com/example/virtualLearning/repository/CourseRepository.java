package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.CategoryTable;
import com.example.virtualLearning.tables.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseTable,Long> {

    @Query(value = "select * from course_tbl c where c.category_id = :categoryId",nativeQuery = true)
    Page<CourseTable> getAllCourseByCategoryId(long categoryId, Pageable pageable);

    @Query(value = "select * from course_tbl c where c.course_id = :courseId",nativeQuery = true)
    Optional<CourseTable> getById(long courseId);
}
