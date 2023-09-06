package com.doctime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.doctor.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
   
}
