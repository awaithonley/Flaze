package com.flaze.repository;

import com.flaze.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);
    Optional<UserEntity> findByUsername(String username);
}
