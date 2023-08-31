package com.doctime.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.UserRepository;
import com.doctime.security.jwt.JwtUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {

        Set<RoleEntity> roles = userRegisterDTO.roles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());
        // Solo se debe poder registrar con un user
        if (roles.size() > 1 || roles.size() == 0) {
            return new ResponseEntity<>("Error en los roles", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = UserEntity.builder()
                .email(userRegisterDTO.email())
                .password(passwordEncoder.encode(userRegisterDTO.password()))
                .roles(roles)
                .build();
        userRepository.save(userEntity);

        String token = jwtUtils.generateAccesToken(userEntity.getEmail());
        UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed", userEntity.getId(), token);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('PATIENT')")
    public String testPatient() {
        return "DASHBOARD DE PATIENT";
    }
}
