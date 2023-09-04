package com.doctime.model.doctor;

import com.doctime.model.location.Location;
import com.doctime.model.specialty.Specialty;
import com.doctime.model.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name="specialty_id")
    private Specialty specialty;

    public Doctor(DataCreateDoctor dataCreateDoctor){
        this.payment_type = dataCreateDoctor.payment_type();
        this.user = dataCreateDoctor.user();
        this.location = dataCreateDoctor.location();
        this.specialty= dataCreateDoctor.specialty();
    }
    
    public void updateDoc(DataUpdateDoctor dataUpdateDoctor){
        if (dataUpdateDoctor.payment_type() != null) {
            this.payment_type = dataUpdateDoctor.payment_type();
        }

        if (dataUpdateDoctor.user() != null) {
            if (this.user != null) {
                
                this.user.setName(dataUpdateDoctor.user().getName());
                this.user.setLast_name(dataUpdateDoctor.user().getLast_name());
                this.user.setDni(dataUpdateDoctor.user().getDni());
                this.user.setGender(dataUpdateDoctor.user().getGender());
                this.user.setBirthday(dataUpdateDoctor.user().getBirthday());
         
            } 
             if (dataUpdateDoctor.location() != null) {
            this.location = dataUpdateDoctor.location();
        }

                   
        // if(dataUpdateDoctor.location() != null){
        //     if(this.location != null){
        //         this.location.setId(dataUpdateDoctor.location().getId());
        //     }
        // }
        
        
        }}
}