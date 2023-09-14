package com.doctime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.UserRepository;
import com.doctime.security.jwt.JwtUtils;
import com.doctime.service.DoctorService;
import com.doctime.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PatientService patientService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository repository;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO.role().equals("PATIENT")) {
            return ResponseEntity.ok(patientService.createPatient(userRegisterDTO));
        }
        if (userRegisterDTO.role().equals("DOCTOR")) {
            return ResponseEntity.ok(doctorService.createDoctor(userRegisterDTO));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/patient/dashboard")
    @PreAuthorize("hasRole('PATIENT')")
    public String testPatient() {
        return "DASHBOARD DE PATIENT";
    }

    @GetMapping("/doctor/dashboard")
    @PreAuthorize("hasRole('DOCTOR')")
    public String testDoctor() {
        return "DASHBOARD DE DOCTOR";
    }
}
