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
public class RecruitPost extends BaseTimeEntity {
    
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
    private String place;
    
    @Column(nullable = false)
    private LocalDateTime meetingDate;
    
    @Column(nullable = false)
    private Integer totalMember; // 총 인원 수
    
    private Integer joinMember; // 현재 인원 수
    
    private String filePath; // 업로드한 이미지 파일의 경로
    
    @Column(nullable = false)
    private LocalDateTime closeDate; // 마감 날짜
    
    private final String postGroup="recruitPost";
    
    public RecruitPost updateRecruitPost(String title, String content, String place, LocalDateTime meetingDate, 
            Integer totalMember, String filePath, LocalDateTime closeDate) {
        this.title=title;
        this.content=content;
        this.place=place;
        this.meetingDate=meetingDate;
        this.totalMember=totalMember;
        this.filePath=filePath;
        this.closeDate=closeDate;
        
        return this;
    }
    
}
