package com.example.project5.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.project5.domain.RecruitPost;

import lombok.Data;

@Data
public class RecruitPostUpdateDto {

    private Integer id;
    private String title;
    private String content;
    private String place;
    private Integer totalMember;
    private String filePath;
    private String fileName;
    
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime closeDate;
    
//
//    public RecruitPost toEntity() {
//        return RecruitPost.builder()
//                .id(id).title(title).content(content).totalMember(totalMember).place(place)
//                .filePath(filePath).fileName(fileName)
//                .closeDate(closeDate).build();
//    }
}
