package com.doctime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findAll();
    
}