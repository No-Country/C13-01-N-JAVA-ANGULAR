package com.doctime.model.doctor;

import com.doctime.model.user.UserEntity;

public record DataUpdateDoctor(
        Long id,
        String paymentTypes,
        double reputation,
        int totalRatings,
        UserEntity user) {
}