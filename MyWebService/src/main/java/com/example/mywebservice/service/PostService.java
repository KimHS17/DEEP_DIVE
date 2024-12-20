package com.example.mywebservice.service;

import com.example.mywebservice.dto.PostDto;
import com.example.mywebservice.entity.Post;
import com.example.mywebservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    // 게시글 작성
    public PostDto createPost(PostDto postDto) {
        Post post = new Post(postDto.getTitle(), postDto.getContent(), postDto.getAuthor());
        Post savePost = postRepository.save(post);
        return convertToDto(savePost);
    }

    // 게시글 목록 조회
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public Optional<PostDto> getPostById(Long id) {
        return postRepository.findById(id)
                .map(this::convertToDto);
    }

    // 게시글 수정
    public PostDto updatePost(Long id, PostDto postDto) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(postDto.getTitle());
                    post.setContent(postDto.getContent());
                    post.setAuthor(postDto.getAuthor());
                    return convertToDto(postRepository.save(post));
                })
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setAuthor(post.getAuthor());
        return postDto;
    }
}
