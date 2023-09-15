import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../shared/models/reservation.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ReservationService {
  private showModal = new BehaviorSubject<boolean>(false);
  public showModal$ = this.showModal.asObservable();

  private apiURL = 'http://localhost:8080';
  public token = localStorage.getItem('token');

  constructor(private http: HttpClient) {}

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

  changeShowModal() {
    this.showModal.next(!this.showModal.value);
  }
}
