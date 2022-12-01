package com.example.project5.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Reply extends BaseTimeEntity {
    
    private Integer id;
    private String replyContent;
    private Integer postId;
    private String postGroup;
    private String writer;
    
    public Reply updateReply(String replyContent) {
        this.replyContent=replyContent;
        
        return this;
    }
    
}
