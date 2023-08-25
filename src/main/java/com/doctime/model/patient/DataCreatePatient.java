package com.doctime.model.patient;

import java.sql.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreatePatient(

 Long id,
    String name,
    String last_name,
    @NotNull
    Gender gender,
    String phone,
    String imagenUrl,
    Date createdAt,
    Date updatedAt,
    String dni
) {


}