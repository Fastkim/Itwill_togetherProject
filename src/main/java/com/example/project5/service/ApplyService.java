package com.example.project5.service;

import org.springframework.stereotype.Service;

import com.example.project5.domain.Apply;
import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.ApplyJoinDto;
import com.example.project5.repository.ApplyRepository;
import com.example.project5.repository.RecruitPostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplyService {
    
    private final ApplyRepository applyrepository;
    private final RecruitPostRepository recruitPostRepository;
    
    public Integer JoinPost(ApplyJoinDto dto) {
        log.info("joinPost(dto={}", dto);
        
        // 포스트 아이디 검색 
        RecruitPost recruitPost = recruitPostRepository.findById(dto.getPostId()).get();
        
        // DTO를 APPLY Entity로 변환
        Apply apply = Apply.builder().recruitPost(recruitPost).joinNickname(dto.getJoinNickname()).build();
        
        // 테이블에 저장
        applyrepository.save(apply);
        
        return apply.getId();
    }
    
    // 신청 삭제
    public Integer delete(Integer applyId) {
        log.info("delete(applyId={})", applyId);
        
        applyrepository.deleteById(applyId);
        
        return applyId;
    }
    
}
