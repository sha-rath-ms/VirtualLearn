package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.SubcategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryTable, Long> {
}