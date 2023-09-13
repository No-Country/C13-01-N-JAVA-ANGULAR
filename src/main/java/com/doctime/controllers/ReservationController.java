package com.doctime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.patient.DataUpdatePatient;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.reservation.DataCreateReservation;
import com.doctime.model.reservation.DataListReservation;
import com.doctime.model.reservation.DataUpdateReservation;
import com.doctime.model.reservation.Reservation;
import com.doctime.repository.ReservationRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<DataListReservation>> listReservations(){
        return ResponseEntity.ok(reservationRepository.findAll().stream().map(DataListReservation::new).toList());
    }

    @PostMapping
    @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<Reservation> registerReservation(
  @RequestBody @Valid DataCreateReservation dataCreateReservation) {
  return new ResponseEntity<>(reservationRepository.save(new
  Reservation(dataCreateReservation)), HttpStatus.CREATED);
  }

   @PutMapping
  @Transactional
  @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<DataUpdateReservation> updatedReservation(@RequestBody @Validated DataUpdateReservation dataUpdateReservation) {
    Reservation reservation = reservationRepository.getReferenceById(dataUpdateReservation.id());
    reservation.updateReser(dataUpdateReservation);

    return ResponseEntity.ok(dataUpdateReservation);

  }

   @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id) {
    Reservation reservation = reservationRepository.getReferenceById(id);
    reservationRepository.delete(reservation);
    return ResponseEntity.noContent().build();
  }
    
}