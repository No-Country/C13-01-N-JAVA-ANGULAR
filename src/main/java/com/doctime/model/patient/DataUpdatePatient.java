package com.doctime.model.patient;

import java.time.LocalDateTime;

import com.doctime.model.user.UserEntity;

public record DataUpdatePatient(
        Long id,
        LocalDateTime birthday,
        String address,
        UserEntity user) {
}