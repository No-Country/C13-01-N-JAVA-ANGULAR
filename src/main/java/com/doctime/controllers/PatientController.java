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

import java.util.HashSet;
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

        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity rolPaciente = RoleEntity.builder().name(ERole.valueOf("PATIENT")).build();
        roles.add(rolPaciente);

        PatientEntity patientEntity = PatientEntity.builder()
                .name(patientDTO.name())
                .last_name(patientDTO.last_name())
                .gender(patientDTO.gender())
                .birthday(patientDTO.birthday())
                .phone(patientDTO.phone())
                .email(patientDTO.email())
                .password(passwordEncoder.encode(patientDTO.password()))
                .roles(roles)
                .build();

        patientRepository.save(patientEntity);

        return ResponseEntity.ok(patientEntity);
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('PATIENT')")
    public String testPatient() {
        return "DASHBOARD DE PATIENT";
    }
}
