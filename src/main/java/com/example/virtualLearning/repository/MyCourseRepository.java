package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.MyCourseTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyCourseRepository extends JpaRepository<MyCourseTable, Long> {

    @Query(value = "select * from my_course_tbl m where m.mobile_number = :mobileNumber", nativeQuery = true)
    List<MyCourseTable> findAllwithMobileNumber(Long mobileNumber, Pageable pageable);

    @Query(value = "SELECT * FROM my_course_tbl p WHERE p.mobile_number = :mobileNumber AND p.course_id= :courseId", nativeQuery = true)
    Optional<MyCourseTable> existsByMobileNumberAndCourseId(Long mobileNumber, Long courseId);

    @Query(value = "select * from my_course_tbl m where m.mobile_number = :mobileNumber and m.completed=1", nativeQuery = true)
    List<MyCourseTable> findAllCompleted(Long mobileNumber, Pageable pageable);

    @Query(value = "select certificate from my_course_tbl m where m.mobile_number = :mobileNumber and m.course_id=:courseId", nativeQuery = true)
    String getCertificate(Long mobileNumber, Long courseId);

    @Query(value = "select * from my_course_tbl m where m.mobile_number =:mobileNumber and m.completed=0", nativeQuery = true)
    List<MyCourseTable> findAllOngoing(Long mobileNumber, Pageable pageable);


}