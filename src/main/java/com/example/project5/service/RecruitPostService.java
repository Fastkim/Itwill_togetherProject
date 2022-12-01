package com.example.project5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project5.domain.RecruitPost;
import com.example.project5.dto.RecruitPostCreateDto;
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
    
    public RecruitPost create(RecruitPostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        RecruitPost entity = recruitPosrRepository.save(dto.toEntity());
        
        return entity;
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
}
