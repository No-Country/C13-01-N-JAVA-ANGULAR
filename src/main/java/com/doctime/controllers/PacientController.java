package com.doctime.controllers;

import com.doctime.models.pacient.PacientDTO;
import com.doctime.models.pacient.PacientEntity;
import com.doctime.models.role.ERole;
import com.doctime.models.role.RoleEntity;
import com.doctime.repository.PacientRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PacientRepository pacientRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerPacient(@Valid @RequestBody PacientDTO pacientDTO) {

        Set<RoleEntity> roles = pacientDTO.roles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        PacientEntity pacientEntity = PacientEntity.builder()
                .username(pacientDTO.username())
                .password(passwordEncoder.encode(pacientDTO.password()))
                .email(pacientDTO.email())
                .roles(roles)
                .build();

        pacientRepository.save(pacientEntity);

        return ResponseEntity.ok(pacientEntity);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('PACIENT')")
    public String accessUser() {
        return "Hola, has accedito con rol de PACIENT";
    }

    // @DeleteMapping("/deleteUser")
    // public String deleteUser(@RequestParam String id) {
    // pacientRepository.deleteById(Long.parseLong(id));
    // return "Se ha borrado el user con id".concat(id);
    // }
}
