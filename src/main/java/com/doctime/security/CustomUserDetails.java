package com.doctime.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    private Long id_user;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String role; // Campo adicional

    public CustomUserDetails(Long id_user, String username, String password,
            Collection<? extends GrantedAuthority> authorities, String role) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.role = role;
    }

    public Long getId_user() {
        return id_user;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
