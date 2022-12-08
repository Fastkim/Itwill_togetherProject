package com.example.project5.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
    
    private double lat;
    private double lng;

    public RecruitPost toEntity() {
        return RecruitPost.builder().title(title).content(content).author(author).place(place).meetingDate(meetingDate)
                .lat(lat).lng(lng).totalMember(totalMember).closeDate(closeDate).build();
    }

}
