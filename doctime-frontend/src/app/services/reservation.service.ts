import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../shared/models/reservation.model';

@Injectable({ providedIn: 'root' })
export class ReservationService {
  constructor(private http: HttpClient) {}
  private apiURL = 'http://localhost:8080';
  public token = localStorage.getItem('token');

  createReservation(reservation: Reservation) {
    return this.http.post(`${this.apiURL}/reservation`, reservation, {
      headers: {
        Authorization: `Bearer ${this.token}`,
      },
    });
  }

  getReservations() {
    return this.http.get(`${this.apiURL}/reservation`, {
      headers: {
        Authorization: `Bearer ${this.token}`,
      },
    });
  }
}
