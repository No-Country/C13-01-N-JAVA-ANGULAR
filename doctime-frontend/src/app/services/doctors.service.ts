import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Doctor } from '../shared/models/doctors.model';

@Injectable({
  providedIn: 'root',
})
export class DoctorsService {
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  doctorsList(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.apiUrl}/doctor`);
  }
}
