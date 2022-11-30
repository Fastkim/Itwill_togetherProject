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
@Entity(name = "RECRUITPOSTS")
@SequenceGenerator(name="RECRUITPOSTS_SEQ_GEN", sequenceName = "RECRUITPOSTS_SEQ" ,allocationSize = 1)
public class RecruitPost extends PostCommon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECRUITPOSTS_SEQ_GEN")
    private Integer id;

    @Column(unique = true , nullable = false)
    private String title; 
    
    @Column(unique = true , nullable = false)
    private String content;
    
    @Column(unique = true , nullable = false)
    private String author;
    
    @Column(nullable = false)
    private String place; // 장소

    private LocalDateTime meetingDate; // 모임날짜
    
    @Column(nullable = false)
    private Integer totalMember; // 총인원
    
    private Integer joinMember; // 현재인원 (디폴트 값 0)
    
    @Column(nullable = false)
    private LocalDateTime closeDate; // 마감날짜
    
    private String titleImg; 
    
    public RecruitPost update(String title, String content, 
            String place, LocalDateTime meetingDate, Integer totalMember) {
        this.title = title;
        this.content = content;
        this.place = place;
        this.meetingDate = meetingDate;
        this.totalMember = totalMember;
        
        return this;
    }
    
    
}
