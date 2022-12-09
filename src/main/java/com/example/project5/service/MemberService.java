package com.example.project5.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project5.domain.Member;
import com.example.project5.dto.MemberRegisterDto;
import com.example.project5.dto.MemberUpdateDto;
import com.example.project5.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    
    public String checkUsername(String username) {
        log.info("checkUsername(username={})", username);
        
        Optional<Member> result = memberRepository.findByUsername(username);
        
        if (result.isPresent()) {
            return "nok";
        } else {
            return "ok";
        }
    }
    
    public Member RegisterMember(MemberRegisterDto dto) {
        log.info("RegisterMember(dto={})", dto);
        
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member entity=memberRepository.save(dto.toEntity());
        log.info("entity = {}", entity);
        
        return entity;
    }
    
    public Member findByUsername(String username) {
        log.info("findByUsername(username={})", username);
        return memberRepository.findByUsername(username).get();
    }
    
    @Transactional
    public Integer update(MemberUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        Member entity = memberRepository.findById(dto.getId()).get();
        
        entity.update(dto.getNickname(), dto.getName(), dto.getPhone(), dto.getEmail());
        
        return entity.getId();
    }

}
