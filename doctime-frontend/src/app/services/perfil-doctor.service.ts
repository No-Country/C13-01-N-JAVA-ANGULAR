import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { AuthService } from './auth.service';
import { DoctorRegister } from '../shared/models/auth.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PerfilDoctorService {
  apiUrl = 'http://localhost:8080/doctor/:id';

  constructor(
    private http: HttpClient,
    private authSvc: AuthService
  ) {}

  getDoctorById(doctorId: number): Observable<any> {
    return this.http.get<DoctorRegister>(`${this.apiUrl}/${doctorId}`);
  }
}
