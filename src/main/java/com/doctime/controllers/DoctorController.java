package com.doctime.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.doctor.DataListDoctor;
import com.doctime.model.doctor.DataUpdateDoctor;
import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.reservation.DataListReservation;
import com.doctime.model.specialty.Specialty;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.ReservationRepository;
import com.doctime.repository.SpecialtyRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

  

    @GetMapping
  @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<List<DataListDoctor>> listDoctors() {
    return ResponseEntity.ok(doctorRepository.findAll().stream().map(DataListDoctor::new).toList());
  }

  //LISTAR DOCTORES POR ESPECIALIDAD

   @GetMapping("/{specialtyId}")
   @PreAuthorize("hasRole('PATIENT')")
    public List<DoctorEntity> getDoctorsBySpecialtyId(@PathVariable  Long specialtyId) {
        return doctorRepository.findBySpecialtyId(specialtyId);
    }

  //  @PutMapping
  // @Transactional
  // @PreAuthorize("hasRole('DOCTOR')")
  // public ResponseEntity<DataUpdateDoctor> updatedDoctor(@RequestBody @Validated DataUpdateDoctor dataUpdateDoctor) {
  //   DoctorEntity doctor = doctorRepository.getReferenceById(dataUpdateDoctor.id());
  //   doctor.updateDoc(dataUpdateDoctor);

  //   return ResponseEntity.ok(dataUpdateDoctor);

  // }

  @PutMapping
@Transactional
@PreAuthorize("hasRole('DOCTOR')")
public ResponseEntity<DataUpdateDoctor> updatedDoctor(@RequestBody @Validated DataUpdateDoctor dataUpdateDoctor) {
    DoctorEntity doctor = doctorRepository.getReferenceById(dataUpdateDoctor.id());

    if (dataUpdateDoctor.specialty() != null) {
        String specialtyName = dataUpdateDoctor.specialty().getName();

        // Verifica si la especialidad ya existe en la tabla Especialidad
        Specialty existingSpecialty = specialtyRepository.findByName(specialtyName);

        if (existingSpecialty == null) {
            // Si la especialidad no existe, crea una nueva instancia
            existingSpecialty = new Specialty(specialtyName);
            existingSpecialty = specialtyRepository.save(existingSpecialty);
        }

        // Asocia la especialidad al Doctor
        doctor.setSpecialty(existingSpecialty);
    }

    doctor.updateDoc(dataUpdateDoctor);
    doctorRepository.save(doctor);

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



   

    
