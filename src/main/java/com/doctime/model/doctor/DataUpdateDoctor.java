package com.doctime.model.doctor;

import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(
       @NotNull Long id,
        String paymentTypes,
        double reputation,
        int totalRatings,
        UserEntity user,
        Specialty specialty
) {

}