package com.doctime.service;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.doctor.DataListDoctor;
import com.doctime.model.doctor.DataUpdateDoctor;
import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.schedule.DataCreateSchedule;
import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.model.specialty.Specialty;
import com.doctime.model.timeRange.TimeRange;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.ScheduleRepository;
import com.doctime.repository.SpecialtyRepository;
import com.doctime.repository.TimeRangeRepository;
import com.doctime.repository.UserRepository;
import com.doctime.security.jwt.JwtUtils;

import jakarta.transaction.Transactional;

@Service
public class DoctorService {
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private DoctorRepository doctorRepository;
        @Autowired
        private SpecialtyRepository specialtyRepository;
        @Autowired
        private ScheduleRepository scheduleRepository;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private JwtUtils jwtUtils;
        @Autowired
        private TimeRangeRepository timeRangeRepository;

        public UserResponseDTO createDoctor(UserRegisterDTO userRegisterDTO) {
                RoleEntity roleREntity = RoleEntity.builder()
                                .name(ERole.valueOf(userRegisterDTO.role()))
                                .build();

                UserEntity userEntity = UserEntity.builder()
                                .email(userRegisterDTO.email())
                                .password(passwordEncoder.encode(userRegisterDTO.password()))
                                .role(roleREntity)
                                .build();
                Specialty specialty = new Specialty("default");
                DoctorEntity doctorEntity = DoctorEntity.builder()
                                .user(userEntity)
                                .specialty(specialty)
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build();
                doctorRepository.save(doctorEntity);

                String token = jwtUtils.generateAccesToken(doctorEntity.getUser().getEmail());
                UserResponseDTO userResponseDTO = new UserResponseDTO("Register completed",
                                doctorEntity.getUser().getId(), token,
                                doctorEntity.getUser().getRole().getName().toString());
                return userResponseDTO;
        }

        public DataListDoctor updateDoctorUser(DoctorEntity doctor, DataUpdateDoctor dataUpdateDoctor) {
                doctor.setPaymentTypes(dataUpdateDoctor.paymentTypes());
                doctor.setReputation(dataUpdateDoctor.reputation());
                doctor.setTotalRatings(dataUpdateDoctor.totalRatings());

                UserEntity user = doctor.getUser();
                user.setName(dataUpdateDoctor.user().getName());
                user.setLast_name(dataUpdateDoctor.user().getLast_name());
                user.setBirthday(dataUpdateDoctor.user().getBirthday());
                user.setGender(dataUpdateDoctor.user().getGender());
                user.setDni(dataUpdateDoctor.user().getDni());
                Specialty specialty = doctor.getSpecialty();
                specialty.setName(dataUpdateDoctor.specialty().getName());

                doctorRepository.save(doctor);
                userRepository.save(user);
                specialtyRepository.save(specialty);
                return new DataListDoctor(doctor);
        }

        @Transactional
        public DataCreateSchedule saveSchedule(DoctorEntity doctor, DataCreateSchedule dataCreateSchedule) {
                // obtener la fecha o null
                ScheduleEntity scheduleExist = scheduleRepository
                                .findByDoctorAndDayOfWeek(doctor, dataCreateSchedule.dayOfWeek())
                                .orElse(null);
                // if existe borrar todas sus horarios y asignarle nuevos
                if (scheduleExist != null) {
                        timeRangeRepository.deleteBySchedule(scheduleExist);
                        for (TimeRange timeRange : dataCreateSchedule.timeRange()) {
                                TimeRange timeRange2 = TimeRange.builder()
                                                .start_time(timeRange.getStart_time())
                                                .schedule(scheduleExist)
                                                .end_time(timeRange.getEnd_time()).build();
                                timeRangeRepository.save(timeRange2);
                        }
                        DataCreateSchedule dataCreateScheduleResp = new DataCreateSchedule(scheduleExist.getId(),
                                        scheduleExist.getDayOfWeek(),
                                        timeRangeRepository.findByScheduleId(scheduleExist.getId()));
                        return dataCreateScheduleResp;
                } else {
                        ScheduleEntity scheduleEntity = ScheduleEntity.builder()
                                        .dayOfWeek(dataCreateSchedule.dayOfWeek())
                                        .created_at(LocalDateTime.now())
                                        .update_at(LocalDateTime.now())
                                        .timeRange(new HashSet<>())
                                        .doctor(doctor).build();
                        ScheduleEntity scheduleNuevo = scheduleRepository.save(scheduleEntity);

                        for (TimeRange timeRange : dataCreateSchedule.timeRange()) {
                                TimeRange timeRange2 = TimeRange.builder()
                                                .start_time(timeRange.getStart_time())
                                                .schedule(scheduleNuevo)
                                                .end_time(timeRange.getEnd_time()).build();
                                timeRangeRepository.save(timeRange2);
                        }
                        DataCreateSchedule dataCreateScheduleResp = new DataCreateSchedule(scheduleNuevo.getId(),
                                        scheduleNuevo.getDayOfWeek(),
                                        timeRangeRepository.findByScheduleId(scheduleNuevo.getId()));
                        return dataCreateScheduleResp;
                }

        }
}
