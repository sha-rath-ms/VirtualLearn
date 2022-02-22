package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseTable, Long> {

    @Query(value = "select * from course_tbl c where c.category_id = :categoryId", nativeQuery = true)
    Page<CourseTable> getAllCourseByCategoryId(long categoryId, Pageable pageable);

    @Query(value = "select * from course_tbl c where c.id = ?1", nativeQuery = true)
    Optional<CourseTable> getById(long courseId);

    @Query(value = "select * from course_tbl c where c.category_id= :categoryId and c.featured=1", nativeQuery = true)
    List<CourseTable> getFeaturedCourses(Long categoryId);

    @Query(value = "select * from course_tbl c where c.category_id= :categoryId and c.beginner=1", nativeQuery = true)
    List<CourseTable> getBeginnerCourses(Long categoryId);

    @Query(value = "select * from course_tbl c where c.name LIKE %:courseName% and c.category_id=:categoryId", nativeQuery = true)
    Page<CourseTable> searchInCategory(String courseName,long categoryId , Pageable pageable);

    @Query(value = "select * from course_tbl c where c.name LIKE %:courseName% ", nativeQuery = true)
    Page<CourseTable> search(String courseName, Pageable pageable);
}