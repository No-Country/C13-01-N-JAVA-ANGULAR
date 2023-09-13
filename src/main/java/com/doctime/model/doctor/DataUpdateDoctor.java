package com.doctime.model.doctor;

import java.time.LocalDateTime;

import com.doctime.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DataUpdateDoctor(
        Long id,
        String paymentTypes,
        double reputation,
        int totalRatings,
        UserEntity user) {
}