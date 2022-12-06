package com.example.project5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.Apply;

public interface ApplyRepository extends JpaRepository<Apply, Integer>{
    
    
    Optional<Apply> findByJoinNickname(String joinNickname);
    
}
