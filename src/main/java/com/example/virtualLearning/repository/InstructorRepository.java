package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.InstructorTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<InstructorTable,Long> {
}
