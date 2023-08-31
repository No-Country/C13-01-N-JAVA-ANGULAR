package com.doctime.model.patient;


import java.util.Date;

public record DataListPatient (
    Long id,
    String name,
    String last_name,
    String gender,
    String phone,
    String imagenUrl,
    Date created_at,
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
        patient.getCreated_at(),
        patient.getUpdatedAt(),
        patient.getDni()
        );
    
    }
    
   
}

