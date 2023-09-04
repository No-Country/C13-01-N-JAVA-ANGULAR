package com.doctime.repository;

import org.springframework.data.repository.CrudRepository;

import com.doctime.model.patient.PatientEntity;

public interface PatientRepository extends CrudRepository<PatientEntity, Long> {

}
