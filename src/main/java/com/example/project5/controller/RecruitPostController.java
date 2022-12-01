package com.example.project5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RecruitPostController {
    
    @GetMapping("/")
    public String post() {
        log.info("post()");
        
        return "/post/create";
    }

}
