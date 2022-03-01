package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.VideoStatusTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoStatusRepository extends JpaRepository<VideoStatusTable,Long> {

    @Query(value = "select  count(v.id) from video_status_tbl v where v.user_id = :userId and v.course_id =:courseId and v.chapter_id = :chapterId  and v.completed = true",nativeQuery = true)
    Integer getCompleted(long userId,long courseId,long chapterId);
}
