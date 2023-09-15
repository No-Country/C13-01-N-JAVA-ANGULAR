package com.doctime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.doctor.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByUserId(Long usuarioId);
    List<DoctorEntity> findBySpecialtyId(Long specialtyId);
}
