package com.doctime.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.doctime.security.CustomUserDetails;

@Service
public class CustomUserService {

    public CustomUserDetails getCurrentCustomUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUserDetails) {
            return (CustomUserDetails) principal;
        }

        return null; // No se pudo obtener el CustomUser actual
    }
}
