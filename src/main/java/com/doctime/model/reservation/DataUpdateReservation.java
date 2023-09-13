package com.doctime.model.reservation;

import com.doctime.model.status.EStatus;

public record DataUpdateReservation(
    Long id,
    String title,
    EStatus status,
    Double price

) {

    
}