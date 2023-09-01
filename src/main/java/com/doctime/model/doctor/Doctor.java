package com.doctime.model.doctor;

import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String payment_type;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity user;

    private String location;
    @ManyToMany
    @JoinColumn(name="specialty_id")
    private Specialty especialty;

}