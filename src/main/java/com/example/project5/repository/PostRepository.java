package com.example.project5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

    
}
