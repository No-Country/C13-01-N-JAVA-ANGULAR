package com.doctime.model.doctor;

import java.time.LocalDateTime;

import com.doctime.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DataListDoctor(

        Long id,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updatedAt,
        String paymentTypes,
        double reputation,
        int totalRatings,
        UserEntity user)

{
    public DataListDoctor(DoctorEntity doctor) {
        this(doctor.getId(),
                doctor.getCreatedAt(),
                doctor.getUpdatedAt(),
                doctor.getPaymentTypes(),
                doctor.getReputation(),
                doctor.getTotalRatings(),
                doctor.getUser());
    }

}