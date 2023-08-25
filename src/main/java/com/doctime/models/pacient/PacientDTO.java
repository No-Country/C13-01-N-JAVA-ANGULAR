package com.doctime.models.pacient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record PacientDTO(
                @Email @NotBlank String email,
                @NotBlank String username,
                @NotBlank String password,
                Set<String> roles) {
}
