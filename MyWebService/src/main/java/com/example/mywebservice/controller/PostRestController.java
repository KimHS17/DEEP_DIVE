package com.example.mywebservice.controller;

import com.example.mywebservice.dto.PostDto;
import com.example.mywebservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    @Autowired
    private PostService postService;

    // 게시글 목록 조회
    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // 게시글 생성
    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
