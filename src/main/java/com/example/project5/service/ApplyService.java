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
    public int delete(String joinNickname, Integer recruitPostId) {
        log.info("delete(joinNickname={}, recruitPostId={})", joinNickname, recruitPostId);
        
        int result = applyrepository.deleteByjoinNickname(joinNickname, recruitPostId);
        
        return result;
    }
        
    
//    
//    public String checkNickname(String nickname) {
//        log.info("checkUsername(nickname={})", nickname);
//
//        Optional<Apply> result = applyrepository.findByJoinNickname(nickname);
//        if (result.isPresent()) { // 일치한 닉네임이 있는 경우.
//            // 신청불가 
//            return "noJoin";
//        } else { 
//            // 신청가능 
//            return "join";
//        }
//    }
    
}
