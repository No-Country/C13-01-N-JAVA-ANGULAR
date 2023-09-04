package com.doctime.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.DoctorrRepository;
import com.doctime.repository.PatientRepository;
import com.doctime.repository.UserRepository;
import com.doctime.security.jwt.JwtUtils;

@Service
public class UserService {

        @Autowired
        private JwtUtils jwtUtils;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private PatientRepository patientRepository;

        @Autowired
        private DoctorrRepository doctorrRepository;

        @Autowired
        private UserRepository userRepository;

        public UserResponseDTO registerPatient(UserRegisterDTO userRegisterDTO) {

                Set<RoleEntity> roles = userRegisterDTO.roles().stream()
                                .map(role -> RoleEntity.builder()
                                                .name(ERole.valueOf(role))
                                                .build())
                                .collect(Collectors.toSet());
                UserEntity userEntity = UserEntity.builder()
                                .email(userRegisterDTO.email())
                                .password(passwordEncoder.encode(userRegisterDTO.password()))
                                .roles(roles)
                                .build();
                userRepository.save(userEntity);
                PatientEntity patientEntity = PatientEntity.builder()
                                .userEntity(userEntity)
                                .build();
                patientRepository.save(patientEntity);

                String token = jwtUtils.generateAccesToken(userEntity.getId().toString(), userEntity.getEmail(),
                                userRegisterDTO.roles());
                UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed", userEntity.getId(),
                                token);
                return userResponseDTO;
        }

        public UserResponseDTO registerDoctor(UserRegisterDTO userRegisterDTO) {

                Set<RoleEntity> roles = userRegisterDTO.roles().stream()
                                .map(role -> RoleEntity.builder()
                                                .name(ERole.valueOf(role))
                                                .build())
                                .collect(Collectors.toSet());
                UserEntity userEntity = UserEntity.builder()
                                .email(userRegisterDTO.email())
                                .password(passwordEncoder.encode(userRegisterDTO.password()))
                                .roles(roles)
                                .build();
                userRepository.save(userEntity);
                DoctorEntity doctorEntity = DoctorEntity.builder()
                                .address("Lima - Lima")
                                .userEntity(userEntity)
                                .build();
                doctorrRepository.save(doctorEntity);
                String token = jwtUtils.generateAccesToken(userEntity.getId().toString(), userEntity.getEmail(),
                                userRegisterDTO.roles());
                UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed",
                                userEntity.getId(), token);

                return userResponseDTO;
        }

}
