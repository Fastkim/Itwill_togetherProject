package com.example.project5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.ChatUser;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long>{
    ChatUser findByEmail(String email);

}
