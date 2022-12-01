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
public class FreeSharePost extends BaseTimeEntity {
    
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String product;
    private String filePath;
    private final String postGroup="freeSharePost";
    
    public FreeSharePost updateFreeSharePost(String title, String content, String product, String filePath) {
        this.title=title;
        this.content=content;
        this.product=product;
        this.filePath=filePath;
        
        return this;
    }
    
}
