package com.doctime.model.user;

import com.doctime.model.gender.EGender;
import com.doctime.model.role.RoleEntity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record DataListUser(
        Long id,
        String name,
        String last_name,
        LocalDate birthday,
        @Enumerated(EnumType.STRING) EGender gender,
        String dni,
        RoleEntity role) {
    public DataListUser(UserEntity user) {
        this(user.getId(),
                user.getName(),
                user.getLast_name(),
                user.getBirthday(),
                user.getGender(),
                user.getDni(),
                user.getRole());
    }
}
