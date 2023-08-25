package com.doctime.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.doctime.model.patient.DataCreatePatient;
import com.doctime.model.patient.DataListPatient;
import com.doctime.model.patient.DataUpdatePatient;
import com.doctime.model.patient.Patient;
import com.doctime.repository.PatientRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import javax.xml.crypto.Data;

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

  
/*
 *   @PostMapping
  public void registerPatient(@RequestBody @Validated DataCreatePatient dataCreatePatient) {
    patientRepository.save(new Patient(dataCreatePatient));
  }
 */


  @PostMapping
  public ResponseEntity<Patient> registrarPaciente(
      @RequestBody @Valid DataCreatePatient dataCreatePatient, UriComponentsBuilder uriComponentsBuilder)  {
        return new ResponseEntity<>(patientRepository.save(new Patient(dataCreatePatient)), HttpStatus.CREATED);

      }
    /*OTRAS FORMAS
         Patient patient = patientRepository.save(new Patient(dataCreatePatient));
        
         URI url = uriComponentsBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
         return ResponseEntity.ok(patientRepository.save(new Patient(dataCreatePatient)));


         Patient patient = patientRepository.save(new Patient(dataCreatePatient));
        
         URI url = uriComponentsBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();  
         return ResponseEntity.created(url).body(patient);
     */
    

  @PutMapping
  @Transactional
  public void updatePatient(@RequestBody @Validated DataUpdatePatient dataUpdatePatient) {
    Patient patient = patientRepository.getReferenceById(dataUpdatePatient.id());
    patient.updatePati(dataUpdatePatient);

  }

  @DeleteMapping("/{id}")
  @Transactional
  public void deletePatient(@PathVariable Long id) {
    Patient patient = patientRepository.getReferenceById(id);
    patientRepository.delete(patient);
  }

}