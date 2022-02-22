package com.example.virtualLearning.repository;

import com.example.virtualLearning.tables.BlockListTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockListRepository extends JpaRepository<BlockListTable,String> {
}
