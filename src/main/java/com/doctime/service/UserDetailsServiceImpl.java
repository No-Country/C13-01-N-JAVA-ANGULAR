package com.doctime.service;

import com.doctime.model.user.UserEntity;
import com.doctime.repository.UserRepository;
import com.doctime.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

                UserEntity userEntity = userRepository.findByEmail(email)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "El email " + email + " no existe."));

                GrantedAuthority authority = new SimpleGrantedAuthority(
                                "ROLE_".concat(userEntity.getRole().getName().toString()));

                return new CustomUserDetails(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(),
                                Collections.singletonList(authority), userEntity.getRole().getName().toString());
        }
}
