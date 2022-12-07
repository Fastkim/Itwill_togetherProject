package com.example.project5.dto;

import com.example.project5.domain.RecruitPost;

import lombok.Data;

@Data
public class CountJoinMemberDto {
    
    private Integer postId;
    private Integer joinMember;
    
    public RecruitPost toEntity() {
        return RecruitPost.builder().id(postId).joinMember(joinMember).build();
    }

}
