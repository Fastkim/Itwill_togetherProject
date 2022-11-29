package com.example.project5.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project5.domain.Post;

@SpringBootTest
public class PostRepositoryTest {
    
    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void test() {
        Post post = Post.builder().title("test").content("테스트").author("admin")
                .place("--").build();
        postRepository.save(post);
    }

}
