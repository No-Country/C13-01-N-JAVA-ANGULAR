package com.doctime.controllers;

import com.doctime.model.patient.PatientDTO;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.repository.PatientRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody PatientDTO patientDTO) {

        Set<RoleEntity> roles = patientDTO.roles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        PatientEntity patientEntity = PatientEntity.builder()
                .username(patientDTO.username())
                .password(passwordEncoder.encode(patientDTO.password()))
                .email(patientDTO.email())
                .roles(roles)
                .build();

        patientRepository.save(patientEntity);

        return ResponseEntity.ok(patientEntity);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('PATIENT')")
    public String testPatient() {
        return "Hola, has accedito con rol de PATIENT";
    }
}
