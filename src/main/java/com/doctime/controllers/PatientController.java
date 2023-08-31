package com.doctime.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.doctime.model.patient.DataCreatePatient;
import com.doctime.model.patient.DataListPatient;
import com.doctime.model.patient.DataUpdatePatient;
import com.doctime.model.patient.Patient;
import com.doctime.repository.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


import java.util.List;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Patient")
public class PatientController {

  @Autowired
  private PatientRepository patientRepository;

  @GetMapping
  public ResponseEntity<List<DataListPatient>> listPatients() {
    System.out.println("Hola paciente");
    return ResponseEntity.ok(patientRepository.findAll().stream().map(DataListPatient::new).toList());
  }

 

  @PostMapping
  public ResponseEntity<Patient> registerPatient(
      @RequestBody @Valid DataCreatePatient dataCreatePatient) {
    return new ResponseEntity<>(patientRepository.save(new Patient(dataCreatePatient)), HttpStatus.CREATED);

  }
 
  @PutMapping
  @Transactional
  public ResponseEntity updatedPatient(@RequestBody @Validated DataUpdatePatient dataUpdatePatient) {
    Patient patient = patientRepository.getReferenceById(dataUpdatePatient.id());
    patient.updatePati(dataUpdatePatient);

     return ResponseEntity.ok( dataUpdatePatient);
   
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id){
    Patient patient = patientRepository.getReferenceById(id);
    patientRepository.delete(patient);
    return ResponseEntity.noContent().build();
  }


  
}