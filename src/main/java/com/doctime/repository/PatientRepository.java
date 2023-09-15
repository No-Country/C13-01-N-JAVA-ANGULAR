package com.doctime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.doctime.model.patient.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAll();



}