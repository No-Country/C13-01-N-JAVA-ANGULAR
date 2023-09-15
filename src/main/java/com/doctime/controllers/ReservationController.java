package com.doctime.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctime.model.doctor.DoctorEntity;
import com.doctime.model.patient.PatientEntity;
import com.doctime.model.reservation.DataCreateReservation;
import com.doctime.model.reservation.DataListReservation;
import com.doctime.model.reservation.DataUpdateReservation;
import com.doctime.model.reservation.ReservationEntity;
import com.doctime.model.status.EStatus;
import com.doctime.repository.DoctorRepository;
import com.doctime.repository.PatientRepository;
import com.doctime.repository.ReservationRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

     @Autowired
    private PatientRepository patientRepository;

     @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<DataListReservation>> listReservations(){
        return ResponseEntity.ok(reservationRepository.findAll().stream().map(DataListReservation::new).toList());
    }

    //LISTAR RESERVAS POR SU ID

    @GetMapping("/{reservationId}")
@PreAuthorize("hasRole('PATIENT') or hasRole('DOCTOR')")
public ResponseEntity<DataListReservation> getReservationById(@PathVariable Long reservationId) {
    // Verificar si el ID de la reserva es nulo o negativo
    if (reservationId == null || reservationId <= 0) {
        return ResponseEntity.badRequest().build();
    }

    // Buscar la reserva por su ID en la base de datos
    Optional<ReservationEntity> reservationOptional = reservationRepository.findById(reservationId);

    if (!reservationOptional.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    // Devolver la reserva encontrada
    DataListReservation reservation = new DataListReservation(reservationOptional.get());
    return ResponseEntity.ok(reservation);
}



    //LISTAR RESERVAS POR ID DEL PACIENTE
    @GetMapping("/patient/{patientId}")
@PreAuthorize("hasRole('PATIENT')")
public ResponseEntity<List<DataListReservation>> listReservationsByPatient(@PathVariable Long patientId) {
    // Verificar si el ID del paciente es nulo o negativo
    if (patientId == null || patientId <= 0) {
        return ResponseEntity.badRequest().build();
    }

    // Verificar si el paciente existe en la base de datos
    Optional<PatientEntity> patientOptional = patientRepository.findById(patientId);

    if (!patientOptional.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    // Realizar la consulta de las reservas para el paciente especificado
    List<DataListReservation> reservations = reservationRepository.findByPatientId(patientId)
            .stream()
            .map(DataListReservation::new)
            .toList();

    // Devolver las reservas encontradas
    return ResponseEntity.ok(reservations);
}


//LISTAR RESERVA POR ID DEL DOCTOR
@GetMapping("/doctor/{doctorId}")
@PreAuthorize("hasRole('DOCTOR')")
public ResponseEntity<List<DataListReservation>> listReservationsByDoctor(@PathVariable Long doctorId) {
    // Verificar si el ID del doctor es nulo o negativo
    if (doctorId == null || doctorId <= 0) {
        return ResponseEntity.badRequest().build();
    }

    // Verificar si el doctor existe en la base de datos
    Optional<DoctorEntity> doctorOptional = doctorRepository.findById(doctorId);

    if (!doctorOptional.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    // Realizar la consulta de las reservas para el doctor especificado
    List<DataListReservation> reservations = reservationRepository.findByDoctorId(doctorId)
            .stream()
            .map(DataListReservation::new)
            .toList();

    // Devolver las reservas encontradas
    return ResponseEntity.ok(reservations);
     }
    


      

    @PostMapping
    @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<ReservationEntity> registerReservation(
  @RequestBody @Valid DataCreateReservation dataCreateReservation) {
  return new ResponseEntity<>(reservationRepository.save(new
  ReservationEntity(dataCreateReservation)), HttpStatus.CREATED);
  }

   @PutMapping
  @Transactional
  @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<DataUpdateReservation> updatedReservation(@RequestBody @Validated DataUpdateReservation dataUpdateReservation) {
    ReservationEntity reservation = reservationRepository.getReferenceById(dataUpdateReservation.id());
    reservation.updateReser(dataUpdateReservation);

    return ResponseEntity.ok(dataUpdateReservation);

  }

   @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id) {
    ReservationEntity reservation = reservationRepository.getReferenceById(id);
    reservationRepository.delete(reservation);
    return ResponseEntity.noContent().build();
  }



  @PatchMapping("status/{reservationId}")
@PreAuthorize("hasRole('DOCTOR')") // Ajusta los permisos según tus necesidades
public ResponseEntity<?> updateReservationStatus(@PathVariable Long reservationId, @RequestBody EStatus newStatus) {
    // Verificar si el ID de la reserva es nulo o negativo
    if (reservationId == null || reservationId <= 0) {
        return ResponseEntity.badRequest().body("ID de reserva no válido");
    }

    // Verificar si la reserva existe en la base de datos
    Optional<ReservationEntity> reservationOptional = reservationRepository.findById(reservationId);

    if (!reservationOptional.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    // Obtener la reserva existente
    ReservationEntity reservation = reservationOptional.get();

    // Actualizar el estado de la reserva con el nuevo estado proporcionado en el cuerpo de la solicitud
    reservation.setStatus(newStatus);

    // Guardar la reserva actualizada en la base de datos
    reservationRepository.save(reservation);

    return ResponseEntity.ok(reservation); // Devolver la reserva actualizada
}

 }