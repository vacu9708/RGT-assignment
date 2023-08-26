package com.rgt.rgt.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    UserEntity findByEmail(String email);

    @Modifying
    @Query(value = "INSERT INTO users (id, email, name) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void insertUser(UUID id, String email, String name);
}