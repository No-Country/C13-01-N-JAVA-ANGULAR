package com.doctime.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(

                @Email(message = "EMAIL not valid") @NotBlank(message = "EMAIL cannot be blank") @Size(max = 80, message = "EMAIL must not exceed 50 characters") String email,

                @NotBlank(message = "PASSWORD cannot be blank") @Size(max = 80, min = 8, message = "PASSWORD must be between 8 and 50 characters") String password,

                @NotBlank(message = "ROLE cannot be empty") String role) {
}
