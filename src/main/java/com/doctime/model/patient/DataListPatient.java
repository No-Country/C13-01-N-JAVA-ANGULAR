package com.doctime.model.patient;

import java.time.LocalDateTime;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

//import com.doctime.model.reservation.Reservation;
import com.doctime.model.user.UserEntity;

public record DataListPatient(

        Long id,
        LocalDateTime birthday,
        String address,
        UserEntity user)

{
    public DataListPatient(PatientEntity patient) {
        this(patient.getId(),
                patient.getBirthday(),
                patient.getAddress(),
                patient.getUser());
    }

}
