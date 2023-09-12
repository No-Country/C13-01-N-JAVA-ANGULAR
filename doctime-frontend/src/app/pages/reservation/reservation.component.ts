import { Component, OnInit } from '@angular/core';

import { Speciality } from 'src/app/models/speciality.model';
import { Doctor } from 'src/app/models/doctor.model';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss'],
})
export class ReservationComponent implements OnInit {
  reservarTurno() {
    throw new Error('Method not implemented.');
  }
  specialties: Speciality[] = [];
  doctors: Doctor[] = [];
  selectedEspecialidad: number | undefined;
  selectedMedico: number | null = null;
  selectedFecha: string | null = null;
  dias: string[] = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes'];
  horarios: string[] = ['09:00 AM', '10:00 AM', '11:00 AM'];
  constructor(private reservationService: ReservationService) {}

  ngOnInit() {
    // Cargo especialidades
    this.cargarEspecialidades();
  }

  //cargar las especialidades disponibles desde el servicio
  cargarEspecialidades() {
    this.specialties = this.reservationService.getSpecialties();
  }

  // Método para cargar los médicos disponibles según la especialidad seleccionada, No esta funcionando
  cargarMedicosPorEspecialidad() {
    if (this.selectedEspecialidad) {
      console.log('Especialidad seleccionada:', this.selectedEspecialidad);

      this.selectedMedico = null;

      this.reservationService
        .getDoctorsBySpecialty(this.selectedEspecialidad)
        .subscribe(
          (doctors) => {
            this.doctors = doctors;
          },
          (error) => {
            console.error('Error al obtener médicos por especialidad:', error);
          }
        );
    }
  }

  //FALTA:
  // Método para cargar los horarios disponibles según el médico y la fecha seleccionada
  // cargarHorariosDisponibles() {}

  // Método para reservar un turno
  // reservarTurno() {
  //   if (
  //     this.selectedEspecialidad &&
  //     this.selectedMedico &&
  //     this.selectedFecha
  //   ) {}
}
