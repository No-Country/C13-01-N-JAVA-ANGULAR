package com.doctime.model.patient;

import java.sql.Date;

public record DataListPatient (
    Long id,
    String name,
    String last_name,
    String gender,
    String phone,
    String imagenUrl,
    Date createdAt,
    Date updatedAt,
    String dni
)

{
    public DataListPatient(Patient patient){
        this(patient.getId(),
        patient.getName(),
        patient.getLast_name(),
        patient.getGender().toString(),
        patient.getPhone(),
        patient.getImagenUrl(),
        patient.getCreatedAt(),
        patient.getUpdatedAt(),
        patient.getDni()
        );
    
    }
    
   
}

