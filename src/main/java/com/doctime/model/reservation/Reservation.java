package com.doctime.model.reservation;

import java.time.LocalDateTime;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.status.EStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_reservation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Temporal(TemporalType.TIMESTAMP) // Utiliza TIMESTAMP para fecha y hora
    @Column(name = "fecha_creacion", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP) // Utiliza TIMESTAMP para fecha y hora
    @Column(name = "fecha_actualizacion")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @Column
    private String title;

    @Column
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorEntity doctor;

    public Reservation(DataCreateReservation dataCreateReservation) {
        this.date = dataCreateReservation.date();
        this.title = dataCreateReservation.title();
        this.status = dataCreateReservation.status();
        this.price = dataCreateReservation.price();
        this.patient = dataCreateReservation.patient();
        this.doctor = dataCreateReservation.doctor();
        this.createdAt = LocalDateTime.now();

    }

    public void updateReser(DataUpdateReservation dataUpdateReservation) {
        if (dataUpdateReservation.date() != null) {
            this.date = dataUpdateReservation.title();
        }
        if (dataUpdateReservation.title() != null) {
            this.title = dataUpdateReservation.title();
        }
        if (dataUpdateReservation.status() != null) {
            this.status = dataUpdateReservation.status();
        }
        if (dataUpdateReservation.price() != null) {
            this.price = dataUpdateReservation.price();
        }
        this.updatedAt = LocalDateTime.now();

    }
}
