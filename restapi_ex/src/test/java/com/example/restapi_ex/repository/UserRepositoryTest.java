package com.example.restapi_ex.repository;

import com.example.restapi_ex.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
    @Autowired
    private UserRepository userRepository;

    // 사용자 저장 및 조회 테스트
    @Test
    void testSaveAndFindById() {
        System.out.println("테스트 시작: User 저장 후 조회 테스트");
        // 1. 새로운 사용자 엔티티 생성
        User user = new User();
        user.setName("Jane");
        user.setEmail("jane@gmail.com");

        // 2. 리포지토리를 통해 사용자 저장
        User savedUser = userRepository.save(user);
        System.out.println("데이터 저장 완료: " + user.getName() + "(이메일: " + user.getEmail() + ")");

        // 3. 저장된 사용자가 잘 조회되는지 겸증
        User fonundUser = userRepository.findById(savedUser.getId()).orElse(null);
        if(fonundUser != null) {
            logger.info("데이터 조회 완료: " + fonundUser.getName() + "(이메일: " + fonundUser.getEmail() + ")");
        } else {
            logger.info("저장된 사용자가 없습니다.");
        }
        assertThat(fonundUser).isNotNull();
        assertThat(fonundUser.getName()).isEqualTo("Jane");
        assertThat(fonundUser.getEmail()).isEqualTo("jane@gmail.com");
    }
}
