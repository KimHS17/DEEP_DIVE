package com.example.mywebservice.controller;

import com.example.mywebservice.dto.PostDto;
import com.example.mywebservice.entity.Post;
import com.example.mywebservice.service.PostService;
import com.example.mywebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    // 게시글 목록 조회
    // http://localhost:8080/posts
    @GetMapping
    public String list(Model model) {
        List<PostDto> postDtos = postService.getAllPosts();
        model.addAttribute("posts", postDtos);
        model.addAttribute("nickname", userService.findNickname());
        return "list";
    }

    // 게시글 작성 : 작성폼
    // http://localhost:8080/posts/create
    @GetMapping("/create")
    public String createForm(Model model) {
        String nickname = userService.findNickname();
        PostDto postDto = new PostDto();
        postDto.setAuthor(nickname);
        model.addAttribute("post", postDto);
        return "create";
    }

    // 게시글 작성 : 게시글 등록
    @PostMapping("/create")
    public String createPost(@ModelAttribute("postDto") PostDto postDto) {
        postService.createPost(postDto);
        return "redirect:/posts";
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        model.addAttribute("post", postDto);
        boolean isAuthor = userService.findNickname().equals(postDto.getAuthor());
        model.addAttribute("isAuthor", isAuthor);
        return "detail";
    }

    // 게시글 수정 : 수정폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        String nickname = userService.findNickname();
        postDto.setAuthor(nickname);
        model.addAttribute("post", postDto);
        return "edit";
    }

    // 게시글 수정 : 게시글 수정
    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute("postDto") PostDto updatepostDto) {
        postService.updatePost(id, updatepostDto);
        return "redirect:/posts";
    }

    // 게시글 삭제
    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
