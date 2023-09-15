package com.doctime.model.reservation;

import java.time.LocalDateTime;

import com.doctime.model.status.EStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public record DataListReservation(
        Long id,
        String date,
        String title,
        EStatus status,
        Double price,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updatedAt,
        Long doctor,
        Long patient) {
    public DataListReservation(ReservationEntity reservation) {
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