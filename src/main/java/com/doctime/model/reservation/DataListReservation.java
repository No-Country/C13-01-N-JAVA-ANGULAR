package com.doctime.model.reservation;

import java.time.LocalDateTime;


import com.doctime.model.status.EStatus;

public record DataListReservation(
    Long id,
    String date,
    String title,
    EStatus status,
    Double price,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Long doctor,
    Long patient
) {
    public DataListReservation(ReservationEntity reservation){
        this(reservation.getId(),
        reservation.getDate(),
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