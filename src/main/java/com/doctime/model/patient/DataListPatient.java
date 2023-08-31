package com.doctime.model.patient;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.doctime.model.reservation.Reservation;



public record DataListPatient(

        Long id,
        String dni,
        int edad)

{
    public DataListPatient(Patient patient) {
        this(patient.getId(),
        patient.getDni(),
        patient.getEdad());

    }

}
