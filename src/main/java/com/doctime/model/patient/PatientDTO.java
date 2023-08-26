package com.doctime.model.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record PatientDTO(
                @Email @NotBlank String email,
                @NotBlank String username,
                @NotBlank String password,
                Set<String> roles) {
}
