import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NotifyService } from 'src/app/services/notify.service';
import { Reservation, Status } from 'src/app/shared/models/reservation.model';
import { ReservationService } from 'src/app/services/reservation.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.scss'],
})
export class ReservationFormComponent {
  @Input() show!: boolean;
  patientId!: number;

  constructor(
    private router: Router,
    private notifySvc: NotifyService,
    private reservationSvc: ReservationService,
    private authSvc: AuthService
  ) {
    this.patientId = parseInt(localStorage.getItem('id') ?? '0');
    console.log(this.patientId);
  }

  reservationForm: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    date: new FormControl(),
    time: new FormControl(),
  });

  closeForm() {
    this.show = false;
  }

  formatDate(date: string): string {
    const parts = date.split('-');
    if (parts.length === 3) {
      const [year, month, day] = parts;
      return `${day}-${month}-${year}`;
    } else {
      return date;
    }
  }

  onReservation() {
    if (!this.reservationForm.valid) {
      this.notifySvc.showError(
        'No se realizó la reserva',
        'Verifica los datos'
      );
      return;
    }

    console.log(this.reservationForm.value);

    const date = this.formatDate(this.reservationForm.value.date);
    const reservation: Reservation = {
      title: this.reservationForm.value.title,
      date: `${date} ${this.reservationForm.value.time}`,
      price: 50,
      doctor: {
        id: 2,
      },
      patient: {
        id: this.patientId,
      },
      status: Status.PENDING,
    };

    console.log(reservation);

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
