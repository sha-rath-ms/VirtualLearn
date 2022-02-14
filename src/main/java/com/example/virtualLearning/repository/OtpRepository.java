package com.example.virtualLearning.repository;


import com.example.virtualLearning.entity.OtpToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<OtpToken, Long> {

}