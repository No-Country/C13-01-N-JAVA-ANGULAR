package com.doctime;

import java.time.LocalDate;
import java.util.Set;

import com.doctime.model.gender.EGender;
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

			PatientEntity patientEntity = PatientEntity.builder()
					.name("Luis")
					.last_name("Rodriguez")
					.gender(EGender.valueOf(EGender.MALE.name()))
					.birthday(LocalDate.parse("1998-08-04"))
					.email("luis@mail.com")
					.password(passwordEncoder.encode("luisluis"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.PATIENT.name()))
							.build()))
					.build();
			patientRepository.save(patientEntity);
		};
	}
}
