package com.doctime.service;

import com.doctime.models.pacient.PacientEntity;
import com.doctime.repository.PacientRepository;

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
        private PacientRepository pacientRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                PacientEntity pacientEntity = pacientRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "El usuario " + username + " no existe."));

                Collection<? extends GrantedAuthority> authorities = pacientEntity.getRoles()
                                .stream()
                                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                                .collect(Collectors.toSet());

                return new User(pacientEntity.getUsername(),
                                pacientEntity.getPassword(),
                                true,
                                true,
                                true,
                                true,
                                authorities);
        }
}
