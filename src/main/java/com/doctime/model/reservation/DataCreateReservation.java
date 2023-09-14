package com.doctime.model.reservation;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.status.EStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataCreateReservation(

        @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}", message = "El formato de fecha debe ser 'dd-MM-yyyy HH:mm'") String date,
        String title,
        EStatus status,
        Double price,
        @NotNull @Valid PatientEntity patient,
        @NotNull @Valid DoctorEntity doctor) {

}