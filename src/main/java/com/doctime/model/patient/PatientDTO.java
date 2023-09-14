package com.doctime.model.patient;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import com.doctime.model.gender.EGender;

public record PatientDTO(

                @NotBlank(message = "NAME cannot be blank") @Size(max = 50, message = "NAME must not exceed 50 characters") String name,

                @NotBlank(message = "LAST_NAME cannot be blank") @Size(max = 50, message = "LAST_NAME must not exceed 50 characters") String last_name,

                @Enumerated(EnumType.STRING) EGender gender,

                @NotNull(message = "BITHDAY cannot be null") LocalDate birthday,

                String phone,

                @Email(message = "EMAIL not valid") @NotBlank(message = "EMAIL cannot be blank") @Size(max = 80, message = "EMAIL must not exceed 50 characters") String email,

                @NotBlank(message = "PASSWORD cannot be blank") @Size(max = 80, min = 8, message = "PASSWORD must be between 8 and 50 characters") String password) {
}
