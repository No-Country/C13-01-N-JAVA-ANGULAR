package com.doctime.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doctime.model.patient.PatientEntity;

import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long> {

    Optional<PatientEntity> findByEmail(String email);

    @Query("select u from PatientEntity u where u.email = ?1")
    Optional<PatientEntity> getName(String email);
}
