package com.example.project5.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project5.domain.Apply;
import com.example.project5.domain.FreeSharePost;
import com.example.project5.domain.Member;
import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.MemberUpdateDto;
import com.example.project5.service.ApplyService;
import com.example.project5.service.FreeSharePostService;
import com.example.project5.service.MemberService;
import com.example.project5.service.RecruitPostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyPageController {
    
    private final RecruitPostService recruitPostService;
    private final FreeSharePostService freeSharePostService;
    private final ApplyService applyService;
    private final MemberService memberService;
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/member/mypage")
    public void initMypage(Principal principal, Model model) {
        String host=principal.getName();
        log.info("initMypage(host={})", host);

        List<RecruitPost> recruitPostList = recruitPostService.readByAuthor(host);
        List<FreeSharePost> freeSharePostList = freeSharePostService.readByAuthor(host);
        List<Apply> applyList = applyService.findByUsername(host);
        model.addAttribute("recruitPostList", recruitPostList);
        model.addAttribute("freeSharePostList", freeSharePostList);
        model.addAttribute("applyList", applyList);
        
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/member/update")
    public String memberUpdate(Principal principal, Model model) {
        String host=principal.getName();
        log.info("update(id={})", host);
        
        Member member=memberService.findByUsername(host);
        
        model.addAttribute("member", member);
        
        return "/member/update";
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/member/update")
    public String memberModify(MemberUpdateDto dto) {
        log.info("memberModify()");
        
        Integer memberId=memberService.update(dto);
        
        return "redirect:/member/mypage";
    }
    
}
