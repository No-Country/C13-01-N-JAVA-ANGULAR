package com.doctime.model.doctor;

import com.doctime.model.location.Location;
import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

public record DataUpdateDoctor(
        Long id,
    String payment_type,
    UserEntity user,
    Location location,
    Specialty specialty
) {

}