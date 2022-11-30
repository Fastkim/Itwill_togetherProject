package com.example.project5.service;

import org.springframework.stereotype.Service;

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
    
    public RecruitPost create(RecruitPostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        RecruitPost entity = recruitPosrRepository.save(dto.toEntity());
        
        return entity;
    }
}
