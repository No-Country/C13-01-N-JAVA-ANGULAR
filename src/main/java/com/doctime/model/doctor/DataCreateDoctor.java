package com.doctime.model.doctor;

import com.doctime.model.location.Location;
import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DataCreateDoctor(

        String payment_type,
        @NotNull @Valid UserEntity user,
        @NotNull @Valid Location location,
        @NotNull @Valid Specialty specialty

) {
}