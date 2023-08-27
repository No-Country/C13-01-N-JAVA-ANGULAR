package com.doctime.model.patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

import com.doctime.model.gender.EGender;
import com.doctime.model.role.RoleEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "NAME cannot be blank")
    @Size(max = 50, message = "NAME must not exceed 50 characters")
    private String name;

    @NotBlank(message = "LAST_NAME cannot be blank")
    @Size(max = 50, message = "LAST_NAME must not exceed 50 characters")
    private String last_name;

    @Enumerated(EnumType.STRING)
    private EGender gender;

    @NotNull(message = "BITHDAY cannot be null")
    private LocalDate birthday;

    private String phone;

    @Email(message = "EMAIL not valid")
    @NotBlank(message = "EMAIL cannot be blank")
    @Size(max = 80, message = "EMAIL must not exceed 50 characters")
    private String email;

    @NotBlank(message = "PASSWORD cannot be blank")
    @Size(max = 80, min = 8, message = "PASSWORD must be between 8 and 50 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<RoleEntity> roles;

}
