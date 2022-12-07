package com.example.project5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project5.dto.ApplyJoinDto;
import com.example.project5.service.ApplyService;
import com.example.project5.service.RecruitPostService;

import groovyjarjarpicocli.CommandLine.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApplyController {
    
    private final ApplyService applyService;
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/apply")
    public ResponseEntity<Integer> joinPostApply(@RequestBody ApplyJoinDto dto) {
        log.info("joinPostApply(dto={})", dto);
        
        Integer applyId = applyService.JoinPost(dto);
        
        return ResponseEntity.ok(applyId);
    }
    
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/api/apply")
    public ResponseEntity<Integer> deleteApply(String joinNickname, Integer recruitPostId){
        log.info("deleteApply(joinNickname={}, recruitPostId={})", joinNickname, recruitPostId);
        
        int result = applyService.delete(joinNickname, recruitPostId);
        
        return ResponseEntity.ok(result);
        
    }
    
    
    
//    @GetMapping("/api/checkid")
//    @ResponseBody
//    // 컨트롤러 메서드가 리턴하는 값이 뷰의 이름이 아니라 클라이언트로 직접 전송되는 데이터인 경우
//    // ->Ajax 요청 처리에 대한 응답을 리턴할 때 사용.
//    public ResponseEntity<String> checkNickname(String nickname){
//        log.info("checkUsername(nickname={})", nickname);
//        
//        String result = applyService.checkNickname(nickname);
//        
//        return ResponseEntity.ok(result);
//    }
    
//    @GetMapping("/post/detail")
//    public void check(Integer id, Model model) {
//        
//        recruitPostService.read(id);
        
    

}
