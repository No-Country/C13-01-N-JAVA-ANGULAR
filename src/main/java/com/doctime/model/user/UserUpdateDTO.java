package com.doctime.model.user;

import java.time.LocalDate;

import com.doctime.model.gender.EGender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(

                @NotBlank(message = "NAME cannot be blank") @Size(max = 50, message = "NAME must not exceed 50 characters") String name,

                @NotBlank(message = "LAST_NAME cannot be blank") @Size(max = 50, message = "LAST_NAME must not exceed 50 characters") String last_name,

                @NotNull(message = "BITHDAY cannot be null") LocalDate birthday,

                @Enumerated(EnumType.STRING) EGender gender,

                @NotBlank(message = "DNI cannot be blank") String dni) {

}
