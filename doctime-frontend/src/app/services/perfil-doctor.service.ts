import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { AuthService } from './auth.service';
import { Observable, map } from 'rxjs';
import { Doctor } from 'src/app/shared/models/doctors.model';

@Injectable({
  providedIn: 'root',
})
export class PerfilDoctorService {
  private apiUrl = 'http://localhost:8080/doctor/:id';
  private apiURI = '/assets/json/doctor.json';

  constructor(
    private http: HttpClient,
    private authSvc: AuthService
  ) {}

  getDoctorById(doctorId: number) {
    return this.http.get(`${this.apiUrl}/${doctorId}`);
  }

  getDoctorByIdJson(doctorId: number): Observable<Doctor> {
    return this.http.get(`${this.apiURI}`).pipe(
      map((data) => {
        const dataDoctors = JSON.parse(JSON.stringify(data)).doctors;
        const doctor = dataDoctors.filter(
          (doctor: { id: number }) =>
            doctor.id === parseInt(doctorId.toString())
        );
        return doctor[0];
      })
    );
  }
}
