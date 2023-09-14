package com.doctime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.doctor.DataListDoctor;
import com.doctime.model.doctor.DataUpdateDoctor;
import com.doctime.model.doctor.DoctorEntity;

import com.doctime.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
  @PreAuthorize("hasRole('DOCTOR')")
  public ResponseEntity<List<DataListDoctor>> listDoctors() {
    return ResponseEntity.ok(doctorRepository.findAll().stream().map(DataListDoctor::new).toList());
  }

   @PutMapping
  @Transactional
  @PreAuthorize("hasRole('DOCTOR')")
  public ResponseEntity<DataUpdateDoctor> updatedDoctor(@RequestBody @Validated DataUpdateDoctor dataUpdateDoctor) {
    DoctorEntity doctor = doctorRepository.getReferenceById(dataUpdateDoctor.id());
    doctor.updateDoc(dataUpdateDoctor);

    return ResponseEntity.ok(dataUpdateDoctor);

  }

    @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id) {
    DoctorEntity doctor = doctorRepository.getReferenceById(id);
    doctorRepository.delete(doctor);
    return ResponseEntity.noContent().build();
  }



   

    
}