package com.example.project5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
@Entity(name = "POSTREPLIES")
@SequenceGenerator(name="POSTREPLIES_SEQ_GEN", sequenceName = "POSTREPLIES_SEQ" ,allocationSize = 1)
public class Reply extends BaseTimeEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTREPLIES_SEQ_GEN")
    private Integer id;
	
	@ManyToOne
    private String replyContent;
	
	@Column(nullable = false)
    private Integer postId;
	
    private String postGroup;

    @Column(nullable = false)
    private String writer;
    
    public Reply updateReply(String replyContent) {
        this.replyContent=replyContent;
        
        return this;
    }
    
}
