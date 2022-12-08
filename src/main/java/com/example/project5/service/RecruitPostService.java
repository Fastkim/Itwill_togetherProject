package com.example.project5.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.countMemberDto;
import com.example.project5.dto.RecruitPostCreateDto;
import com.example.project5.dto.RecruitPostUpdateDto;
import com.example.project5.repository.RecruitPostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RequiredArgsConstructor
@Service
public class RecruitPostService {

    private final RecruitPostRepository recruitPosrRepository;
    
    @Transactional(readOnly = true)
    public List<RecruitPost> read(){
        log.info("read()");
        return recruitPosrRepository.findByOrderByIdDesc();
    }
    
    @Transactional(readOnly = true)
    public List<RecruitPost> readByAuthor(String author) {
        log.info("readByAuthor(author={})", author);
        return recruitPosrRepository.findByAuthorOrderByIdDesc(author);
    }
    
    @Transactional(readOnly = true)
    public RecruitPost read(Integer id) {
        log.info("read(id={})", id);
        return recruitPosrRepository.findById(id).get();
    }

    public Integer delete(Integer id) {
        log.info("delete(id={})" , id);
        
        recruitPosrRepository.deleteById(id);
        
        return id;
    }
    
    public RecruitPost create(RecruitPostCreateDto dto, MultipartFile file) throws IOException {
        log.info("create(dto={})", dto);
        
//        RecruitPost entity = recruitPosrRepository.save(dto.toEntity());
        RecruitPost entity = dto.toEntity();
        
        // 파일 저장 경로 설정 
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img"; 
        
        
        UUID uuid = UUID.randomUUID();
        // 파일 고유 이름 랜덤 생성
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(filePath ,fileName); // 파일 저장소
        file.transferTo(saveFile); // throws Exception

        entity.setFileName(fileName);
        entity.setFilePath("/img/" + fileName);
        
        
        
        return recruitPosrRepository.save(entity);
    }
    
    @Transactional
    public Integer update(RecruitPostUpdateDto dto, MultipartFile file) throws Exception {
        log.info("update(dto={})", dto);
        
        RecruitPost entity = recruitPosrRepository.findById(dto.getId()).get();
        
        if (file.isEmpty()) {
            entity.updateRecruitPost(dto.getTitle(), dto.getContent(), dto.getPlace(), 
                    dto.getTotalMember(), dto.getFilePath(), dto.getFileName(), dto.getCloseDate());
        }
        
        
        return entity.getId();
    }
    
    public List<RecruitPost> search(String type, String keyword) {
        log.info("search(type={}, keyword={}", type, keyword);
        
        List<RecruitPost> list = new ArrayList<>();
        switch(type) {
        case "t":
            list = recruitPosrRepository.searchByTitle(keyword);
            break;
        case "c":
            list = recruitPosrRepository.searchByKeyword(keyword);
            break;
        case "tc":
            list = recruitPosrRepository.searchByKeyword(keyword);
            break;
        case "a":
            list = recruitPosrRepository.searchByAuthor(keyword);
            break;
        }
        return list;
    }

    
}
