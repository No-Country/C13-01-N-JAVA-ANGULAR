package com.doctime.model.user;

import java.time.LocalDate;
import java.util.Set;

import com.doctime.model.gender.EGender;
import com.doctime.model.role.RoleEntity;

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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
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

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<RoleEntity> roles;
}