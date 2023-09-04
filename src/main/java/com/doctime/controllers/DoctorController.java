package com.doctime.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.doctor.DataCreateDoctor;
import com.doctime.model.doctor.DataListDoctor;
import com.doctime.model.doctor.DataUpdateDoctor;
import com.doctime.model.doctor.Doctor;
import com.doctime.model.patient.Patient;
import com.doctime.repository.DoctorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/Doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<DataListDoctor>> listDoctors(){
        return ResponseEntity.ok(doctorRepository.findAll().stream().map(DataListDoctor::new).toList());
    }

    @PostMapping
    public ResponseEntity<Doctor> registerDoctor(@RequestBody @Valid DataCreateDoctor dataCreateDoctor){
        return new ResponseEntity<>(doctorRepository.save(new Doctor(dataCreateDoctor)), HttpStatus.CREATED);

    }

    //actualización de doctor

    @PutMapping
    @Transactional
    public ResponseEntity updatedDoctor(@RequestBody @Validated DataUpdateDoctor dataUpdateDoctor){
        Doctor doctor = doctorRepository.getReferenceById(dataUpdateDoctor.id());
        doctor.updateDoc(dataUpdateDoctor);
        return ResponseEntity.ok(dataUpdateDoctor);

    }

      @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id){
    Doctor  doctor = doctorRepository.getReferenceById(id);
    doctorRepository.delete(doctor);
    return ResponseEntity.noContent().build();
  }
}