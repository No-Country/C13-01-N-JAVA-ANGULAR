package com.doctime.model.patient;

import java.sql.Date;

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
    private Date createdAt;
    private Date updatedAt;
    private String dni;
    

    public Patient(DataCreatePatient dataCreatePatient){
        this.name= dataCreatePatient.name();
        this.last_name= dataCreatePatient.last_name();
        this.gender=dataCreatePatient.gender();
        this.phone=dataCreatePatient.phone();
        this.imagenUrl= dataCreatePatient.imagenUrl();
        this.createdAt =dataCreatePatient.createdAt();
        this.updatedAt=dataCreatePatient.updatedAt();
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
        

        /*
         *  String last_name,
    Gender gender,
    String phone,
    String dni
         */
       
    }
    
    
    /*last_patient varchar(100),
date_birthday date,
gender enum('Masculino', 'Femenino'),
phone char(20),
imageUrl varchar(100),
createdAt date,
updatedAt date,
dni char(20),
primary key(id_patient)
 */
    
}