package com.doctime.model.user;

import java.time.LocalDate;

import com.doctime.model.gender.EGender;
import com.doctime.model.role.RoleEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonIgnore
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column
    private String name;

    @Column
    private String last_name;

    @Column
    private LocalDate birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @Column(unique = true)
    private String dni;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false) // por defecto ya es EAGER
    @JoinColumn(name = "id_role")
    private RoleEntity role;
}