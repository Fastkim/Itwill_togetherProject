package com.example.project5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.ChatRoom;

public interface ChatMessageRepository extends JpaRepository<ChatRoom,Long>{

}
