package com.example.project5.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @GetMapping("/post/list")
    public String list(Model model) {
        log.info("list");
        
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
    
    @GetMapping({"/post/detail" , "/post/modify"})
    public void detail(Integer id, Model  model) {
        log.info("detail(id={})", id);
        
        RecruitPost post = recruitPostService.read(id);
        
        model.addAttribute("post", post);
    }
    
    @PostMapping("/post/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})" , id);
        
        Integer postId = recruitPostService.delete(id);
        
        attrs.addFlashAttribute("deletePostId" , postId);
        
        return "redirect:/";
    }
    
     

}
