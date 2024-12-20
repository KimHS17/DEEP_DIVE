package com.delivery.db.user;

import com.delivery.db.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, UserStatus status);

    Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password, UserStatus status);
}
