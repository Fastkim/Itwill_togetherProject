package com.example.project5.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class PostCommon {
    
    @CreatedDate
    private LocalDateTime createdTime; 
    
    @LastModifiedDate
    private LocalDateTime modifiedTime;

}
