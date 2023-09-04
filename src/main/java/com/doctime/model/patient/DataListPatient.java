package com.doctime.model.patient;


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
