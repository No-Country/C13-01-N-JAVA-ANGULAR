package com.doctime.model.patient;

import java.util.Date;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.doctime.model.reservation.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
   

    

    public Patient(DataCreatePatient dataCreatePatient){
        this.edad = dataCreatePatient.edad();
    
        this.dni=dataCreatePatient.dni();    
    }

    public void updatePati(DataUpdatePatient dataUpdatePatient)
    {
      
        if(dataUpdatePatient.dni() !=null){
            this.dni=dataUpdatePatient.dni();
        }

     
        
       
    }
    
}