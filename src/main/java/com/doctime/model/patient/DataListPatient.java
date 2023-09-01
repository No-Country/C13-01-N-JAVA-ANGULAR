package com.doctime.model.patient;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.doctime.model.reservation.Reservation;
import com.doctime.model.user.UserEntity;



public record DataListPatient(

        Long id,
        String dni,
        int edad,
        UserEntity user)

{
    public DataListPatient(Patient patient) {
        this(patient.getId(),
        patient.getDni(),
        patient.getEdad(),
        patient.getUser());

    }

}
