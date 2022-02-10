package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.ContentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentTable,Long> {
}
