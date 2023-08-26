package com.doctime;

import java.util.Set;

import com.doctime.model.patient.PatientEntity;
import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DoctimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctimeApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PatientRepository patientRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {

			PatientEntity userEntity = PatientEntity.builder()
					.email("admin@mail.com")
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			PatientEntity userEntity2 = PatientEntity.builder()
					.email("patient@mail.com")
					.username("patient")
					.password(passwordEncoder.encode("patient"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.PATIENT.name()))
							.build()))
					.build();

			PatientEntity userEntity3 = PatientEntity.builder()
					.email("doctor@mail.com")
					.username("doctor")
					.password(passwordEncoder.encode("doctor"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.DOCTOR.name()))
							.build()))
					.build();

			patientRepository.save(userEntity);
			patientRepository.save(userEntity2);
			patientRepository.save(userEntity3);
		};
	}
}
