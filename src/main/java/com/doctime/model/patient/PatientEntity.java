package com.doctime.model.patient;

import java.time.LocalDateTime;

import com.doctime.model.user.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDateTime birthday;

    @Column
    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    



    public void updatePati(DataUpdatePatient dataUpdatePatient) {

        if (dataUpdatePatient.birthday() != null) {
            this.birthday = dataUpdatePatient.birthday();
        }
        if (dataUpdatePatient.address() != null) {
            this.address = dataUpdatePatient.address();

        }
        if (dataUpdatePatient.user() != null) {
            if (this.user != null) {
                this.user.setName(dataUpdatePatient.user().getName());
                this.user.setLast_name(dataUpdatePatient.user().getLast_name());
                this.user.setDni(dataUpdatePatient.user().getDni());
                this.user.setGender(dataUpdatePatient.user().getGender());
                this.user.setBirthday(dataUpdatePatient.user().getBirthday());
            }
            /*
             * else {
             * // Si el usuario asociado no existe, puedes crearlo aquí
             * this.user = new UserEntity();
             * // Suponiendo que UserEntity tenga métodos para establecer sus atributos
             * this.user.setNombre(dataUpdatePatient.user().getNombre());
             * this.user.setOtroAtributo(dataUpdatePatient.user().getOtroAtributo());
             * // Continúa estableciendo otros atributos del usuario aquí
             * }
             */

        }

    }

}