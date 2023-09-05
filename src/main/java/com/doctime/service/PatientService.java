package com.doctime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.PatientRepository;
import com.doctime.security.jwt.JwtUtils;

@Service
public class PatientService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public UserResponseDTO createPatient(UserRegisterDTO userRegisterDTO) {
        RoleEntity roleREntity = RoleEntity.builder()
                .name(ERole.valueOf(userRegisterDTO.role()))
                .build();

        UserEntity userEntity = UserEntity.builder()
                .email(userRegisterDTO.email())
                .password(passwordEncoder.encode(userRegisterDTO.password()))
                .role(roleREntity)
                .build();

        PatientEntity patient = PatientEntity.builder().user(userEntity).build();
        patientRepository.save(patient);

        String token = jwtUtils.generateAccesToken(patient.getUser().getEmail());
        UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed", patient.getUser().getId(), token);
        return userResponseDTO;
    }
}
