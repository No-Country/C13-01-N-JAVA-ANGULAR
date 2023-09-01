package com.doctime.model.patient;

import com.doctime.model.user.UserEntity;

public record DataUpdatePatient(
    Long id,
    String dni,
    int edad,
    UserEntity user
) {
    
}