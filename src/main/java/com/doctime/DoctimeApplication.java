package com.doctime;

import java.util.Set;

import com.doctime.models.ERole;
import com.doctime.models.RoleEntity;
import com.doctime.models.UserEntity;
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
					.email("admin@mail.com")
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			UserEntity userEntity2 = UserEntity.builder()
					.email("user@mail.com")
					.username("user")
					.password(passwordEncoder.encode("user"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();

			UserEntity userEntity3 = UserEntity.builder()
					.email("invited@mail.com")
					.username("invited")
					.password(passwordEncoder.encode("invited"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.INVITED.name()))
							.build()))
					.build();

			userRepository.save(userEntity);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
		};
	}
}
