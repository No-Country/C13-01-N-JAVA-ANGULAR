package com.doctime.model.doctor;

import com.doctime.model.location.Location;
import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

public record DataListDoctor(
    Long id,
    String payment_type,
    UserEntity user,
    Location location,
    Specialty specialty
) {
    public DataListDoctor(Doctor doctor){
        this(doctor.getId(),
        doctor.getPayment_type(),
        doctor.getUser(),
        doctor.getLocation(),
        doctor.getSpecialty());

    }
    
}