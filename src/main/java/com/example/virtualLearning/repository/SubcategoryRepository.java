package com.example.virtualLearning.repository;

import com.example.virtualLearning.entity.Category;
import com.example.virtualLearning.tables.SubcategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryTable, Category> {

    @Query(value = "select * from subcategory s where s.category = :category", nativeQuery = true)
    Optional<SubcategoryTable> getByCategory(Category category);
}
