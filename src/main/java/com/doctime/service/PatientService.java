package com.doctime.service;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.doctime.model.patient.DataListPatient;
import com.doctime.model.patient.DataUpdatePatient;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.repository.PatientRepository;
import com.doctime.security.jwt.JwtUtils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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

    //LISTAR PACIENTES
 

    

}


  //ACTUALIZAR PACIENTE
//   @PutMapping
//   @Transactional
//   @PreAuthorize("hasRole('PATIENT')")
//   public ResponseEntity<DataUpdatePatient> updatedPatient(@RequestBody @Validated DataUpdatePatient dataUpdatePatient) {
//     PatientEntity patient = patientRepository.getReferenceById(dataUpdatePatient.id());
//     patient.updatePati(dataUpdatePatient);

//     return ResponseEn
    

