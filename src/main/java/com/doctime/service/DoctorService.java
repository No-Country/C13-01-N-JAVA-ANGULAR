package com.doctime.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.UserRepository;
import com.doctime.security.CustomUserDetails;
import com.doctime.security.jwt.JwtUtils;

@Service
public class DoctorService {
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private DoctorRepository doctorRepository;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private JwtUtils jwtUtils;

        public UserResponseDTO createDoctor(UserRegisterDTO userRegisterDTO) {
                RoleEntity roleREntity = RoleEntity.builder()
                                .name(ERole.valueOf(userRegisterDTO.role()))
                                .build();

                UserEntity userEntity = UserEntity.builder()
                                .email(userRegisterDTO.email())
                                .password(passwordEncoder.encode(userRegisterDTO.password()))
                                .role(roleREntity)
                                .build();
                DoctorEntity doctorEntity = DoctorEntity.builder()
                                .user(userEntity)
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build();
                doctorRepository.save(doctorEntity);

                String token = jwtUtils.generateAccesToken(doctorEntity.getUser().getEmail());
                UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed",
                                doctorEntity.getUser().getId(),
                                token);
                return userResponseDTO;
        }

        // public void addSchedule(LocalDate day, LocalTime startTime, LocalTime
        // endTime) {
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();
        // CustomUserDetails userDetails = (CustomUserDetails)
        // authentication.getPrincipal();
        // DoctorEntity doctorEntity =
        // doctorRepository.findByUserId(userDetails.getId_user());
        // String id_user = jwtUtils.getUsernameFromToken(null);
        // // terminar
        // }
}
