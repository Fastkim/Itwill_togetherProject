package com.example.project5.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/post/create")
    public String post() {
        log.info("post()"); 
        
        return "/post/create";
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/post/create")
    public String create(RecruitPostCreateDto dto, RedirectAttributes attrs, @RequestParam("imgFile") MultipartFile postImg ) throws Exception {
        log.info("create(dto={})" , dto);
        
        RecruitPost entity = recruitPostService.create(dto, postImg);
        
        attrs.addFlashAttribute("createId", entity.getId());
        
        return "redirect:/post/list";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/post/detail" , "/post/modify"})
    public void detail(Integer id, Model  model) {
        log.info("detail(id={})", id);
        
        RecruitPost post = recruitPostService.read(id);
        
        model.addAttribute("post", post);
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/post/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})" , id);
        
        Integer postId = recruitPostService.delete(id);
        
        attrs.addFlashAttribute("deletePostId" , postId);
        
        return "redirect:/";
    }
    
    @GetMapping("/post/search")
    public String search(String type, String keyword, Model model) {
        log.info("search(type={}, keyword={}", type, keyword);
        
        List<RecruitPost> list = recruitPostService.search(type, keyword); 
        model.addAttribute("list",list);
        
        return "/post/list";
    }
    
     

}
