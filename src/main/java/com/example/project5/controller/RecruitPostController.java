package com.example.project5.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project5.domain.Apply;
import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.RecruitPostCreateDto;
import com.example.project5.dto.RecruitPostUpdateDto;
import com.example.project5.service.ApplyService;
import com.example.project5.service.RecruitPostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RecruitPostController {

    private final RecruitPostService recruitPostService;
    private final ApplyService applyService;

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
    public String create(RecruitPostCreateDto dto, RedirectAttributes attrs,
            @RequestParam("imgFile") MultipartFile fileName) throws IOException {
        log.info("create(dto={})", dto);

        RecruitPost entity = recruitPostService.create(dto, fileName);

        attrs.addFlashAttribute("createId", entity.getId());

        return "redirect:/post/list";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping({ "/post/detail", "/post/modify" })
    public void detail(Integer id, Model model, Principal principal) {
        String username = principal.getName();
        String exist = "no";
        String isFull = "no";
        log.info("detail(postId={}, username={})", id, username);

        RecruitPost post = recruitPostService.read(id);

        List<Apply> applyList = applyService.findByRecruitPostId(id);
        Integer countMember = applyList.size();

        if (countMember >= post.getTotalMember()) {
            isFull = "yes";
        }

        for (Apply a : applyList) {
            if (username.equals(a.getJoinNickname())) {
                exist = "yes";
                break;
            }
        }

        model.addAttribute("post", post);
        model.addAttribute("countMember", countMember);
        model.addAttribute("exist", exist);
        model.addAttribute("isFull", isFull);

    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/post/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})", id);

        Integer postId = recruitPostService.delete(id);

        attrs.addFlashAttribute("deletePostId", postId);

        return "redirect:/";
    }

    @PostMapping("/post/update")
    public String update(RecruitPostUpdateDto dto) throws Exception {

        Integer postId = recruitPostService.update(dto);
        log.info("postId={}",postId);

        return "redirect:/post/detail?id=" + dto.getId();
    }
    
    @PostMapping("/post/updateImg")
    public String updateImg(RecruitPostUpdateDto dto, 
    		@RequestParam("imgFile") MultipartFile fileName) throws Exception {
    	
    	Integer postId = recruitPostService.updateImg(dto, fileName);
    	
    	
    	log.info("postId={}",postId);
    	
    	return "redirect:/post/detail?id=" + dto.getId();
    }

    @GetMapping("/post/search")
    public String search(String type, String keyword, Model model) {
        log.info("search(type={}, keyword={}", type, keyword);

        List<RecruitPost> list = recruitPostService.search(type, keyword);
        model.addAttribute("list", list);

        return "/post/list";
    }

    @GetMapping("/map/main")
    public void mapAddress(Model model) {

        List<RecruitPost> list = recruitPostService.read();
        model.addAttribute("list", list);
    }

}
