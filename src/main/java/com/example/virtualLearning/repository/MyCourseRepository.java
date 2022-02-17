package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.MyCourseTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyCourseRepository extends JpaRepository<MyCourseTable, Long> {
    @Query(value="select * from my_course_tbl m where m.mobile_number = ?1")
    List<MyCourseTable> findAllwithMobileNumber(Long mobileNumber, Pageable pageable);

    @Query(value="SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM my_course_tbl p WHERE p.mobile_number = :mobileNumber AND p.course_id= :courseId")
    Boolean existsByMobileNumberAndCourseId(Long mobileNumber,Long courseId);

}