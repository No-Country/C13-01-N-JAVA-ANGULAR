package com.doctime.service;

import com.doctime.model.patient.PatientEntity;
import com.doctime.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private PatientRepository patientRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                PatientEntity patientEntity = patientRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "El usuario " + username + " no existe."));

                Collection<? extends GrantedAuthority> authorities = patientEntity.getRoles()
                                .stream()
                                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                                .collect(Collectors.toSet());

                return new User(patientEntity.getUsername(),
                                patientEntity.getPassword(),
                                true,
                                true,
                                true,
                                true,
                                authorities);
        }
}
