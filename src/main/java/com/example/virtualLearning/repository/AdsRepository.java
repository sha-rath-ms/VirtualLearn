package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.AdsTable;
import com.example.virtualLearning.tables.CourseTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends JpaRepository<AdsTable,Long> {
    @Query(value = "select * from course_tbl c,ads_tbl a where c.id = a.course_id", nativeQuery = true)
    Page<CourseTable> getAllAds(Pageable pageable);
}
