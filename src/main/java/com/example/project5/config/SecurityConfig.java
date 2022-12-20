package com.example.project5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.project5.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// 컨트롤러 메서드들에서 @PreAuthorize, @PostAuthorize 애너테이션을 이용할 수 있도록.
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration // 스프링 부트 앱 환경설정(configuration)을 자바 코드로 설정
@RequiredArgsConstructor
@AllArgsConstructor
@EnableWebSecurity

public class SecurityConfig {
    private MemberService memberService;
	
    @Bean // 스프링 컨텍스트에서 생성, 관리하는 객체 - 필요한 곳에 의존성 주입
    // 암호화(복호화) 알고리즘 객체
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
         
        http.formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login_home")
        .defaultSuccessUrl("/")
        .and()
        .logout()
        .logoutSuccessUrl("/");
     
        
        
        // 로그인/로그아웃 관련 설정
//        http.formLogin(Customizer.withDefaults())
//            .logout() // 로그아웃 관련 설정 시작
//            .logoutSuccessUrl("/"); // 로그아웃 성공 후에 이동한 URL 설정.
        
        
//        http.authorizeHttpRequests() // 요청에 따른 권한 설정 시작.
//            .antMatchers("/community/festivalPostCreate", "/community/festivalPostCreate", "/community/festivalPostDetail", "/community/festivalPostModify" ) // "/post", "/api/reply"로 시작하는 모든 경로
//            .hasRole("ADMIN") // USER 권한을 가지고 있는 사용자만 접근 가능
//            .anyRequest()
//            .authenticated(); // 그 이외의 모든 요청
            
            
        return http.build();
    }
    

//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
}
