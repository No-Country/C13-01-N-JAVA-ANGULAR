import { Component, OnInit } from '@angular/core';
import { PerfilDoctorService } from 'src/app/services/perfil-doctor.service';
import { ActivatedRoute } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { Doctor } from 'src/app/shared/models/doctors.model';

@Component({
  selector: 'app-public-perfil-doctor',
  templateUrl: './public-perfil-doctor.component.html',
  styleUrls: ['./public-perfil-doctor.component.scss'],
})
export class PublicPerfilDoctorComponent implements OnInit {
  show = false;
  doctorId!: number;
  doctor?: Doctor;

  constructor(
    public perfilDoctorSvc: PerfilDoctorService,
    private reservationSvc: ReservationService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.reservationSvc.showModal$.subscribe((res) => {
      this.show = res;
    });
    this.doctorId = this.route.snapshot.params['id'];
    this.getDoctor(this.doctorId);
  }

  openReservationForm() {
    this.reservationSvc.changeShowModal();
  }

  getDoctor(id: number) {
    this.perfilDoctorSvc.getDoctorByIdJson(id).subscribe((res) => {
      this.doctor = res;
    });
  }
}
