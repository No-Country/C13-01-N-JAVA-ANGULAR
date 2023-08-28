package com.doctime.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.doctime.model.user.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
