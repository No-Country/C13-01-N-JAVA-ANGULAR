package com.doctime.model.reservation;

import java.time.LocalDateTime;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.status.EStatus;

public record DataListReservation(
    Long id,
    String title,
    EStatus status,
    Double price,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Long doctor,
    Long patient
) {
    public DataListReservation(Reservation reservation){
        this(reservation.getId(),
        reservation.getTitle(),
        reservation.getStatus(),
        reservation.getPrice(),
        reservation.getCreatedAt(),
        reservation.getUpdatedAt(),
        reservation.getDoctor().getId(),
        reservation.getPatient().getId()

        );
    }
    
}