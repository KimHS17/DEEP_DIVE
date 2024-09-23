package com.example.mywebservice.service;

import com.example.mywebservice.dto.AddUserDto;
import com.example.mywebservice.entity.User;
import com.example.mywebservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailService userDetailService;

    public Long save(AddUserDto addUserDto) {
        User user = User.builder()
                .email(addUserDto.getEmail())
                .password(passwordEncoder.encode(addUserDto.getPassword()))
                .nickname(addUserDto.getNickname())
                .build();
        return userRepository.save(user).getId();
    }

    public String findNickname() {
        return userRepository.findByEmail(userDetailService.getUser().getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getNickname();
    }
}
