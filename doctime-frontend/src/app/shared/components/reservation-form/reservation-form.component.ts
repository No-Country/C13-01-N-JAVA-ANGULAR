import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NotifyService } from 'src/app/services/notify.service';
import { Reservation } from '../../models/reservation.model';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.scss'],
})
export class ReservationFormComponent {
  constructor(
    private router: Router,
    private notifySvc: NotifyService,
    private reservationSvc: ReservationService
  ) {}

  reservationForm: FormGroup = new FormGroup({
    title: new FormControl('', [
      Validators.required,
      Validators.pattern('[0-9]{10}'),
    ]),
    date: new FormControl(),
    time: new FormControl(),
  });

  onReservation() {
    if (!this.reservationForm.valid) {
      this.notifySvc.showError(
        'No se realizó la reserva',
        'Verifica los datos'
      );
      return;
    }

    const reservation: Reservation = {
      title: this.reservationForm.value.title,
      date: `${this.reservationForm.value.date} ${this.reservationForm.value.time}`,
    };

    this.reservationSvc.createReservation(reservation).subscribe({
      next: () => {
        this.notifySvc.showSuccess(
          'Reserva realizada',
          'La reserva se realizó correctamente'
        );
      },
      complete: () => {
        this.router.navigate(['/profile']);
      },
    });
  }
}
