package com.doctime.repository;

import org.springframework.data.repository.CrudRepository;

import com.doctime.model.doctor.DoctorEntity;

public interface DoctorrRepository extends CrudRepository<DoctorEntity, Long> {

}
