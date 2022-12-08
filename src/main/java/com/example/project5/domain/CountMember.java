package com.example.project5.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="COUNTMEMBER")
@SequenceGenerator(name="COUNTMEMBER_SEQ_GEN" , sequenceName = "COUNTMEMBER_SEQ", allocationSize = 1)
public class CountMember {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTMEMBER_SEQ_GEN")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RecruitPost recruitPost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Apply apply;
	
}
