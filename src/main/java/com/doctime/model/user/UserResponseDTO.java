package com.doctime.model.user;

public record UserResponseDTO(
                String message,
                Long id,
                String token,
                String role) {
}
