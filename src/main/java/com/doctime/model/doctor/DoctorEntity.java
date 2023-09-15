package com.doctime.model.doctor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;
import com.doctime.repository.SpecialtyRepository;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_specialty", nullable = true)
    private Specialty specialty;


        

    public void updateDoc(DataUpdateDoctor dataUpdateDoctor) {
        if (dataUpdateDoctor.paymentTypes() != null) {
            this.paymentTypes = dataUpdateDoctor.paymentTypes();
        }
        if (dataUpdateDoctor.reputation() != -1) {
            this.reputation = dataUpdateDoctor.reputation();
        }
        if (dataUpdateDoctor.totalRatings() != -1) {
            this.totalRatings = dataUpdateDoctor.totalRatings();
        }
    
        if (dataUpdateDoctor.user() != null) {
            if (this.user != null) {
                this.user.setName(dataUpdateDoctor.user().getName());
                this.user.setLast_name(dataUpdateDoctor.user().getLast_name());
                this.user.setDni(dataUpdateDoctor.user().getDni());
                this.user.setGender(dataUpdateDoctor.user().getGender());
                this.user.setBirthday(dataUpdateDoctor.user().getBirthday());
            }
        }
    
        if (dataUpdateDoctor.specialty() != null) {
            if (this.specialty != null) {
                // Actualiza el nombre de la especialidad si se proporciona en dataUpdateDoctor
                if (dataUpdateDoctor.specialty().getName() != null) {
                    this.specialty.setName(dataUpdateDoctor.specialty().getName());
                }
            } else {
                // Si no hay una especialidad actual, verifica si se proporciona en dataUpdateDoctor y crea una nueva
                if (dataUpdateDoctor.specialty().getName() != null) {
                    this.specialty = new Specialty(dataUpdateDoctor.specialty().getName());
                }
            }
        }
    }
    
}