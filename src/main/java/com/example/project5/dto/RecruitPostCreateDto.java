package com.example.project5.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.example.project5.domain.RecruitPost;

import lombok.Data;

@Data
public class RecruitPostCreateDto {

    private String title;
    private String content;
    private String author;
    private String place;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime meetingDate;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime closeDate;

    private Integer totalMember;
    
    // 파일 업로드 테스트
    private MultipartFile attachFile;
    private List<MultipartFile> imageFiles;

    public RecruitPost toEntity() {
        return RecruitPost.builder().title(title).content(content).author(author).place(place).meetingDate(meetingDate)
                .totalMember(totalMember).closeDate(closeDate).build();
    }

}
