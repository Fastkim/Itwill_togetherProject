package com.example.project5.controller;//전 컨트롤러 패키지 이름에 web.controller라고 붙였어요!! 참고하세유~!

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project5.domain.FreeSharePost;
import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.FreeSharePostCreateDto;
import com.example.project5.dto.FreeSharePostUpdateDto;
import com.example.project5.service.FreeSharePostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/freeshare")
public class FreeSharePostController {
    private final FreeSharePostService freeSharePostService;
    
    @GetMapping("/list")
    public String list(Model model,@RequestParam(value="page", defaultValue = "0")int page) {
        log.info("list()");
        //TODO 
        //List<FreeSharePost> list = freeSharePostService.read();
        Page<FreeSharePost> paging=this.freeSharePostService.getList(page);
        model.addAttribute("paging",paging);
        //model.addAttribute("list", list);
        
        return "/freeShare/list";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/create")
    public void create() {
        log.info("create()-get방식");
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public String create(RedirectAttributes attrs,FreeSharePostCreateDto dto, @RequestParam("filePath") MultipartFile file) throws Exception {
        log.info("create(dto={})-post방식",dto);
        
        FreeSharePost entity = freeSharePostService.create(dto, file);
        //작성된 포스트의 번호를 리다이렉트되는 페이지로 전달, 이게 필요한 이유는 나중에 modal 메시지를 띄울 때 사용하려구..
        attrs.addFlashAttribute("createdId", entity.getId());
        
        return "redirect:/freeshare/list";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/detail", "/modify"})
    public void detail(Integer id, Model model) {
        log.info("detail or modify(id={})", id);
        
        FreeSharePost freeSharePost=freeSharePostService.read(id);
        model.addAttribute("post", freeSharePost);
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/modify")
    public String update(FreeSharePostUpdateDto dto) {
        log.info("update(dto={})", dto);
        Integer id=freeSharePostService.update(dto);
        
        return "redirect:/freeshare/detail?id="+id;
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})", id);
        
        Integer freeShareId = freeSharePostService.delete(id);
        attrs.addFlashAttribute("deletePostId" , freeShareId);
        
        return "redirect:/freeshare/list";
    }
    
    @GetMapping("/search")
    public String search(String type, String keyword, Model model) {
        log.info("search(type={}, keyword={})", type, keyword);
        
        List<FreeSharePost> list = freeSharePostService.search(type, keyword); 
        System.out.println("테스트..."+ list.toString());
        model.addAttribute("list",list);
        
        return "/freeshare/search";
    }
    @GetMapping("/practice")
    public void practice() {
        log.info("연습..");
        
    }
}
