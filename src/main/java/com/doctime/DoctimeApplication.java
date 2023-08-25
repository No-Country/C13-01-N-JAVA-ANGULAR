package com.doctime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctimeApplication.class, args);

		System.out.println("hola world");
	}

}
