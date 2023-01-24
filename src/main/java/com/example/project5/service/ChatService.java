package com.example.project5.service;

import org.springframework.stereotype.Service;

import com.example.project5.repository.ChatMessageRepository;
import com.example.project5.repository.ChatRoomRepository;
import com.example.project5.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {
	
	private final ChatMessageRepository chatMessageRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final MemberRepository memberRepository;
	
	

}
