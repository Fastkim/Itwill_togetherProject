package com.example.project5.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project5.domain.RecruitPost;
import com.example.project5.service.MemberService;
import com.example.project5.service.RecruitPostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyPageController {
    
    private final RecruitPostService recruitPostService;
    private final MemberService memberService;
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/member/mypage")
    public void initMypage(Principal principal, Model model) {
        String host=principal.getName();
        log.info("initMypage(host={})", host);

        List<RecruitPost> recruitPostList = recruitPostService.readByAuthor(host);
        model.addAttribute("recruitPostList", recruitPostList);
        
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/member/update")
    public String memberUpdate(Principal principal, Model model) {
        String host=principal.getName();
        log.info("update(id={})", host);
        
        return "/member/update";
    }
    
}
