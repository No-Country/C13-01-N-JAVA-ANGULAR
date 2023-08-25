package com.doctime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.patient.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long>{

    
}