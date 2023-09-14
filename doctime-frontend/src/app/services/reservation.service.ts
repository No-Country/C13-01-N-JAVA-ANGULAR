import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../shared/models/reservation.model';

@Injectable({ providedIn: 'root' })
export class ReservationService {
  constructor(private http: HttpClient) {}
  private apiURL = 'http://localhost:3000';

  createReservation(reservation: Reservation) {
    return this.http.post(`${this.apiURL}/reservation`, reservation);
  }

  getReservations() {
    return this.http.get(`${this.apiURL}/reservation`);
  }
}
