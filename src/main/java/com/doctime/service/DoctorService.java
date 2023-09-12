package com.doctime.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.schedule.DataCreateSchedule;
import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.DoctorRepository;
import com.doctime.security.jwt.JwtUtils;

@Service
public class DoctorService {
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private DoctorRepository doctorRepository;
        @Autowired
        private JwtUtils jwtUtils;
        @Autowired
        private CustomUserService customUserService;
        @Autowired
        private ScheduleSerive scheduleSerive;

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

        public ScheduleEntity addSchedule(DataCreateSchedule dataCreateSchedule) {
                // obtener el id del doctor
                Long id = customUserService.getCurrentCustomUser().getId_user();
                return scheduleSerive.saveSchedule(id, dataCreateSchedule);
        }
}
