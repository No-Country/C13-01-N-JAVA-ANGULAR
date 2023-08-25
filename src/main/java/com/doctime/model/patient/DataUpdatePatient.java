package com.doctime.model.patient;

import jakarta.validation.constraints.NotNull;

public record DataUpdatePatient(
    @NotNull Long id,
    String name,
    String last_name,
    Gender gender,
    String phone,
    String dni
) {
    
}