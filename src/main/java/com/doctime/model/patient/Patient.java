package com.doctime.model.patient;



import com.doctime.model.user.UserEntity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_Patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dni;
    private int edad;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity user;

    public Patient(DataCreatePatient dataCreatePatient) {
        this.edad = dataCreatePatient.edad();

        this.dni = dataCreatePatient.dni();
        this.user = dataCreatePatient.user();
      }

    public void updatePati(DataUpdatePatient dataUpdatePatient) {

        if (dataUpdatePatient.dni() != null) {
            this.dni = dataUpdatePatient.dni();
        }
         if (dataUpdatePatient.edad() != -1) {
            this.edad = dataUpdatePatient.edad();
        
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
             *  else {
                // Si el usuario asociado no existe, puedes crearlo aquí
                this.user = new UserEntity();
                // Suponiendo que UserEntity tenga métodos para establecer sus atributos
                this.user.setNombre(dataUpdatePatient.user().getNombre());
                this.user.setOtroAtributo(dataUpdatePatient.user().getOtroAtributo());
                // Continúa estableciendo otros atributos del usuario aquí
            }
            */
           

           }
        

    }

}