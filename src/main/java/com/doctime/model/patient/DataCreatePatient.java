package com.doctime.model.patient;

import com.doctime.model.user.UserEntity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DataCreatePatient(

        String dni,
        int edad,
        @NotNull
        @Valid
        UserEntity user) {

}