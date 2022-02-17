package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.SubcategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryTable, Long> {
    List<SubcategoryTable> findByCategoryId(Long categoryId);
}