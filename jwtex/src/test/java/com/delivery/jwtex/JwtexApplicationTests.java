package com.delivery.jwtex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class JwtexApplicationTests {
    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate() {
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 7777);

        var expiredAt = LocalDateTime.now().plusSeconds(30);

        var jwtToken = jwtService.create(claims, expiredAt);

        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation() {
        var token = "eeyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo3Nzc3LCJleHAiOjE3MzIwNjMwOTJ9.FybhPnDO0NbHzZIXxAumz7uTMiG3FQO12H7D-hTU5na";
        jwtService.validation(token);
    }

}
