package com.doctime.model.reservation;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.status.EStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DataCreateReservation (
    String title,
    EStatus status,
    Double price,
   @NotNull @Valid PatientEntity patient,
   @NotNull @Valid DoctorEntity doctor
){
    
}