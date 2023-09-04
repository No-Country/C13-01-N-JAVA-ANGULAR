package com.doctime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}