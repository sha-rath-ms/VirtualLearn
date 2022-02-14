package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseTable, Long> {
    Page<CourseTable> findById(long id);

    @Query(value = "select * from course_tbl  where name LIKE %:courseName% and category=:filter", nativeQuery = true)
    Page<CourseTable> search(String courseName, String filter, Pageable pageable);


    @Query(value = "select * from course_tbl  where category=:category", nativeQuery = true)
    Page<CourseTable> findByCategory(String category, Pageable pageable);

}
