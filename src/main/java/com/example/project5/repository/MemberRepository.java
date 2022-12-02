package com.example.project5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project5.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    @EntityGraph(attributePaths = "roles")
    Optional<Member> findByUsername(String username);

}
