package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSubcategoryRepository extends JpaRepository<UserTable, Long> {

    @Query(value = "select * from course_subcategory_tbl c where c.subcategory_id = :subcategoryId",nativeQuery = true)
    List<Long> getCourse(long subcategoryId);
}