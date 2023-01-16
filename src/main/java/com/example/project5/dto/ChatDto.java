package com.example.project5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
// 채팅 내용 dto
    
    //입장 ,대화, 퇴장
    public enum MessageType{
        ENTER, TALK, LEAVE;
    }
    
    private MessageType type;
    private String roomId; // 방번호
    private String sender; // 채팅을 보낸 사람
    private String message; // 메시지 내용
    private String time; // 메시지 발송 시간
    
    

}
