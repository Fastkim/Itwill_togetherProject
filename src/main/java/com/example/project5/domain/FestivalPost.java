package com.example.project5.domain;

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
public class FestivalPost extends BaseTimeEntity {
    
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String place;
    private String filePath;
    private final String postGroup="festivalPost";
    
    public FestivalPost updateRecruitPost(String title, String content, String place, String filePath) {
        this.title=title;
        this.content=content;
        this.place=place;
        this.filePath=filePath;
        
        return this;
    }
}
