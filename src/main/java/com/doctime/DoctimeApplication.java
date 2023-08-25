package com.doctime;

import java.util.Set;

import com.doctime.models.pacient.PacientEntity;
import com.doctime.models.role.ERole;
import com.doctime.models.role.RoleEntity;
import com.doctime.repository.PacientRepository;

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
	PacientRepository pacientRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {

			PacientEntity userEntity = PacientEntity.builder()
					.email("admin@mail.com")
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			PacientEntity userEntity2 = PacientEntity.builder()
					.email("pacient@mail.com")
					.username("pacient")
					.password(passwordEncoder.encode("pacient"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.PACIENT.name()))
							.build()))
					.build();

			PacientEntity userEntity3 = PacientEntity.builder()
					.email("doctor@mail.com")
					.username("doctor")
					.password(passwordEncoder.encode("doctor"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.DOCTOR.name()))
							.build()))
					.build();

			pacientRepository.save(userEntity);
			pacientRepository.save(userEntity2);
			pacientRepository.save(userEntity3);
		};
	}
}
