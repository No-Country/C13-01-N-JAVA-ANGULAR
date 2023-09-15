package com.doctime.model.patient;

import java.time.LocalDateTime;

import com.doctime.model.user.UserEntity;


import jakarta.validation.constraints.NotNull;

public record DataUpdatePatient(
        @NotNull Long id,
         LocalDateTime birthday,
        String address,
        UserEntity user) {
}