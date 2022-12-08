package com.example.project5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.CountMember;

public interface CountMemberRepository extends JpaRepository<CountMember, Integer>{

	
}
