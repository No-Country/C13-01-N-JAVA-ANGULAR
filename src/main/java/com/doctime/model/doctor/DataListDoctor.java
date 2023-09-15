package com.doctime.model.doctor;

import java.time.LocalDateTime;

import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

public record DataListDoctor(
    Long id,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String paymentTypes,
    double reputation,
    int totalRatings,
    UserEntity user,
    Specialty specialty

) {
    public DataListDoctor(DoctorEntity doctor){
        this(doctor.getId(),
        doctor.getCreatedAt(),
        doctor.getUpdatedAt(),
        doctor.getPaymentTypes(),
        doctor.getReputation(),
        doctor.getTotalRatings(),
        doctor.getUser(),
        doctor.getSpecialty()
        
        );
    }
  
    
    
    
}