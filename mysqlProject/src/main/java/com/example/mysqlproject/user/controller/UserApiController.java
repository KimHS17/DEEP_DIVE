package com.example.mysqlproject.user.controller;

import com.example.mysqlproject.user.db.UserEntity;
import com.example.mysqlproject.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private final UserRepository userRepository;

    // http://localhost:8080/api/user/find-all
    @GetMapping("/find-all")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    // http://localhost:8080/api/user/name?name=John
    @GetMapping("/name")
    public void autoSave(@RequestParam String name) {
        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .build();
        userRepository.save(userEntity);
    }
}
