package com.example.restapi_ex.controller;

import com.example.restapi_ex.dto.UserDto;
import com.example.restapi_ex.entity.User;
import com.example.restapi_ex.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate; // REST 요청을 테스트하기 위한 TestRestTemplate

    @Autowired
    private UserRepository userRepository; // 실제 데이터베이스와 상호작용하는 JPA 레포지토리

    @BeforeEach
    void setUp() {
        System.out.println("[테스트 준비] 데이터베이스의 모든 사용자 데이터 삭제");
        userRepository.deleteAll();;
    }

    // 사용자 생성 API 테스트
    @Test
    void testCreateUser() {
        // 1. 테스트할 사용자 DTO 생성
        System.out.println("[테스트] 새로운 사용자 John 생성 준비");
        UserDto userDto = new UserDto();
        userDto.setName("John");
        userDto.setEmail("john@gmail.com");

        // 2. HTTP 요청을 위한 HttpEntity 객체 생성
        System.out.println("[테스트] HttpEntity 생성하여 사용자 데이터 준비");
        HttpEntity<UserDto> request = new HttpEntity<>(userDto);

        // 3. REST API 호출 - POST 요청
        System.out.println("[테스트] /user 경로로 POST 요청 보내기");
        ResponseEntity<User> response = restTemplate.exchange("/user", HttpMethod.POST, request, User.class);

        // 4. 응답 상태 및 내용 검증
        System.out.println("[검증] 응답 상태 코드: " + response.getStatusCode());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(userDto.getName());
        assertThat(response.getBody().getEmail()).isEqualTo(userDto.getEmail());

        System.out.println(("[성공] 사용자 생성 테스트 성공"));
    }

    // 사용자 조회 API 테스트
    @Test
    void testGetUserById() {
        // 1. 테스트할 사용자 DTO 생성
        System.out.println("[테스트] 사용자 John 준비");
        User user = new User();
        user.setName("John");
        user.setEmail("john@gmail.com");
        userRepository.save(user);

        // 2. REST API 호출 - POST 요청
        System.out.println("[테스트] /user 경로로 GET 요청 보내기");
        ResponseEntity<User> response = restTemplate.getForEntity("/user/" + user.getId(), User.class);

        // 3. 응답 상태 및 내용 검증
        System.out.println("[검증] 응답 데이터: " + response.getBody());
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName().equals(user.getName()));
        assertThat(response.getBody().getEmail().equals(user.getEmail()));
    }
}
