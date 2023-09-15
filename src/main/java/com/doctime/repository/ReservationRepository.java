package com.doctime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.reservation.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findAll();

    List<ReservationEntity> findByPatientId(Long id);

    List<ReservationEntity> findByDoctorId(Long id);

}