package com.doctime.model.patient;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String name;
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String imagenUrl;
    private Date created_at;
    private Date updatedAt;
    private String dni;
    

    public Patient(DataCreatePatient dataCreatePatient){
        this.name= dataCreatePatient.name();
        this.last_name= dataCreatePatient.last_name();
        this.gender=dataCreatePatient.gender();
        this.phone=dataCreatePatient.phone();
        this.imagenUrl= dataCreatePatient.imagenUrl();
        this.created_at= new Date(); 
        this.dni=dataCreatePatient.dni();    
    }

    public void updatePati(DataUpdatePatient dataUpdatePatient)
    {
        if(dataUpdatePatient.name() != null){
            this.name=dataUpdatePatient.name();
        }
        if(dataUpdatePatient.last_name() !=null){
            this.last_name=dataUpdatePatient.last_name();
        }
        if(dataUpdatePatient.gender() !=null){
            this.gender=dataUpdatePatient.gender();
        }
        if(dataUpdatePatient.phone() !=null){
            this.last_name=dataUpdatePatient.phone();
        }
        if(dataUpdatePatient.dni() !=null){
            this.last_name=dataUpdatePatient.dni();
        }

        this.updatedAt=new Date();
        
       
    }
    
}