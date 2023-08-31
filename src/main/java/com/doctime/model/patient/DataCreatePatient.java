package com.doctime.model.patient;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

public record DataCreatePatient(

    String name,
    String last_name,
    @NotNull
    Gender gender,
    String phone,
    String imagenUrl,
    String dni
) {


}