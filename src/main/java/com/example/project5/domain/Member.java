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
public class Member {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String name;
    private String phone;
    private String email;
    private String gender;
    private Integer postCount;
    private String likeField;
}
