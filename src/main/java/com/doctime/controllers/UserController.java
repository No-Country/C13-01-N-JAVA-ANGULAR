package com.doctime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.user.UserRegisterDTO;
import com.doctime.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {

        if (userRegisterDTO.roles().size() > 1 || userRegisterDTO.roles().size() == 0) {
            return new ResponseEntity<>("Error en los roles", HttpStatus.BAD_REQUEST);
        }
        if (userRegisterDTO.roles().contains("PATIENT")) {
            return ResponseEntity.ok(userService.registerPatient(userRegisterDTO));
        }
        if (userRegisterDTO.roles().contains("DOCTOR")) {
            return ResponseEntity.ok(userService.registerDoctor(userRegisterDTO));
        }
        return new ResponseEntity<>("Error en los roles", HttpStatus.BAD_REQUEST);
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
