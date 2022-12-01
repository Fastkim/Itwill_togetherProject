package com.example.project5.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.RecruitPostCreateDto;
import com.example.project5.service.RecruitPostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RecruitPostController {
    
    private final RecruitPostService recruitPostService;
    
    @GetMapping("/")
    public String list(Model model) {
        log.info("list()");
        
        List<RecruitPost> list = recruitPostService.read();
        model.addAttribute("list", list);
        
        return "/post/list";
    }
    
    @GetMapping("/post/create")
    public String post() {
        log.info("post()");
        
        return "/post/create";
    }
    
    @PostMapping("/post/create")
    public String create(RecruitPostCreateDto dto, RedirectAttributes attrs) {
        log.info("create(dto={})" , dto);
        
        RecruitPost entity = recruitPostService.create(dto);
        
        attrs.addFlashAttribute("createId", entity.getId());
        
        return "redirect:/";
    }
    
    

}
