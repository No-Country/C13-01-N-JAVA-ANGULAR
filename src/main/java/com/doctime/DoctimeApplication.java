package com.doctime;

import java.util.Set;

import com.doctime.model.role.ERole;
import com.doctime.model.role.RoleEntity;
import com.doctime.model.user.UserEntity;
import com.doctime.repository.UserRepository;

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
	UserRepository userRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {

			UserEntity userEntity = UserEntity.builder()
					.email("luis@mail.com")
					.password(passwordEncoder.encode("luisluis"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.PATIENT.name()))
							.build()))
					.build();
			userRepository.save(userEntity);
		};
	}
}
