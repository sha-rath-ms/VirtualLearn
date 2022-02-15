package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.CategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryTable, Long> {
}