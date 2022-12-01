package com.example.project5.dto;

import java.time.LocalDateTime;

import com.example.project5.domain.RecruitPost;

import lombok.Data;

@Data
public class RecruitPostCreateDto {

    private String title;
    private String content;
    private String author;
    private String place;

    private LocalDateTime meetingDate;

    private LocalDateTime closeDate;

    private Integer totalMember;

    public RecruitPost toEntity() {
        return RecruitPost.builder().title(title).content(content).author(author).place(place).meetingDate(meetingDate)
                .totalMember(totalMember).closeDate(closeDate).build();
    }

}
