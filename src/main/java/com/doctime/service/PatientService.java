package com.doctime.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doctime.model.patient.PatientDTO;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.model.user.UserRegisterDTO;
import com.doctime.model.user.UserResponseDTO;
import com.doctime.model.user.UserUpdateDTO;
import com.doctime.repository.PatientRepository;
import com.doctime.repository.UserRepository;
import com.doctime.security.jwt.JwtUtils;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    public String updatePatient(Long id, UserUpdateDTO userUpdateDTO, PatientDTO patientDTO) {
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow(NullPointerException::new);
        UserEntity userEntity = userRepository.findById(patientEntity.getUserEntity().getId())
                .orElseThrow(NullPointerException::new);

        userEntity.setName(userUpdateDTO.name());
        userEntity.setLast_name(userUpdateDTO.last_name());
        userEntity.setBirthday(userUpdateDTO.birthday());
        userEntity.setGender(userUpdateDTO.gender());
        userEntity.setDni(userUpdateDTO.dni());

        patientEntity.setPhone(patientDTO.phone());
        patientEntity.setUserEntity(userEntity);

        patientRepository.save(patientEntity);
        return "Datos actualizados correctamente";
    }
}
