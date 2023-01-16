package com.example.project5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="CHATUSER")
@SequenceGenerator(name="CHATUSER_SEQ_GEN", sequenceName = "CHATUSER_SEQ", allocationSize = 1)
public class ChatUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHATUSER_SEQ_GEN")
    private Long id;
    
    @Column(nullable = false)
    private String nickName;
    
    private String email;
    
    private String passwd;
    
    private String provider;
    

}
