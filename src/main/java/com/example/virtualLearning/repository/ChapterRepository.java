package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ChapterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterTable,Long> {
}
