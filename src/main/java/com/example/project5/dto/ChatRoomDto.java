package com.example.project5.dto;

import java.util.HashMap;
import java.util.UUID;

import lombok.Data;

@Data
public class ChatRoomDto {
// 채팅룸 
    private String roomId; // 채팅방 아이디
    private String roomName; // 채팅방 이름
    private Integer userCount; // 채팅방 인원수
    
    private HashMap<String, String> userlist = new HashMap<String, String>();
    
    public ChatRoomDto create(String roomName) {
        ChatRoomDto chatRoom = new ChatRoomDto();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;
        
        return chatRoom;
    }
}

