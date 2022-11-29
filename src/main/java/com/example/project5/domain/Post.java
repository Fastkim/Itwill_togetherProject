package com.example.project5.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name = "PPOSTS")
@SequenceGenerator(name="PPOST_SEQ_GEN", sequenceName = "PPOST_SEQ" ,allocationSize = 1)
public class Post extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PPOST_SEQ_GEN")
    private Integer id;

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용 

    @Column(nullable = false)
    private String author; // 작성자
    
    @Column(nullable = false)
    private String place; // 장소 

    private LocalDateTime meetingDate; // 모임날짜
    
    private LocalDateTime applicationDate; // 신청날짜
    
    private String titleImg; 
    
    
    
    
}
