import { Injectable } from '@angular/core';
import { Speciality } from '../models/speciality.model';
import { Doctor } from '../models/doctor.model';

import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private specialties: Speciality[] = [
    new Speciality(1, 'Pediatría'),
    new Speciality(2, 'Cardiología'),
    new Speciality(3, 'Dermatología'),
    new Speciality(4, 'Urologia'),
  ];

  private doctors: Doctor[] = [
    new Doctor(1, 'Dr. Juan Pérez', 1), // Asociado a Pediatría
    new Doctor(2, 'Dr. María Rodríguez', 2), // Asociado a Cardiología
    new Doctor(3, 'Dr. Carlos Sánchez', 1), // Asociado a Pediatría
  ];

  getSpecialties(): Speciality[] {
    return this.specialties;
  }

  getDoctorsBySpecialty(specialityId: number): Observable<Doctor[]> {
    const filteredDoctors = this.doctors.filter(
      (doctor) => doctor.specialityId === specialityId
    );
    return of(filteredDoctors); // Reever logica :C
  }

  getHorariosDisponibles(idMedico: number, fecha: string): string[] {
    const horariosSimulados = [
      {
        medicoId: 1,
        fecha: '2023-08-30',
        horarios: ['09:00 AM', '10:00 AM', '11:00 AM'],
      },
      {
        medicoId: 2,
        fecha: '2023-08-30',
        horarios: ['02:00 PM', '03:00 PM', '04:00 PM'],
      },
    ];

    // Busca los horarios disponibles para el médico y fecha seleccionados
    const horarios = horariosSimulados.find(
      (h) => h.medicoId === idMedico && h.fecha === fecha
    );

    return horarios ? horarios.horarios : [];
  }
}
