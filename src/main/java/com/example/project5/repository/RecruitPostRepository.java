package com.example.project5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.RecruitPost;

public interface RecruitPostRepository extends JpaRepository<RecruitPost, Integer>{

    List<RecruitPost> findByOrderByIdDesc();

    
}
