package com.example.virtualLearning.repository;


import com.example.virtualLearning.tables.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitsRepository extends JpaRepository<UserTable, Long> {
}