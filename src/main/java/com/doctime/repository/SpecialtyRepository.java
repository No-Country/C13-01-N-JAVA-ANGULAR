package com.doctime.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.doctime.model.specialty.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long>{
    Specialty findByName(String name);

   
}