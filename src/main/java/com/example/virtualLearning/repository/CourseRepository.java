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

    @Query(value = "select * from course_tbl  where name LIKE %:courseName%", nativeQuery = true)
    Page<CourseTable> search(String courseName, Pageable pageable);

}
