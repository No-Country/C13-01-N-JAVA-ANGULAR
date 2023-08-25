package com.doctime.model.patient;

import java.sql.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DataCreatePatient(

 Long id,
    String name,
    String last_name,
    @NotBlank
    Gender gender,
    String phone,
    String imagenUrl,
    Date createdAt,
    Date updatedAt,
    String dni
) {


}