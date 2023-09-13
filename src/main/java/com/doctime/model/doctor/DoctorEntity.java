package com.doctime.model.doctor;

import java.time.LocalDateTime;
import java.util.Set;

import com.doctime.model.schedule.ScheduleEntity;
import com.doctime.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime updatedAt;

    @Column
    private String paymentTypes;

    @Column
    private double reputation;

    @Column
    private int totalRatings;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    // @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade =
    // CascadeType.ALL)
    // private Set<ScheduleEntity> scheduleEntity;

}