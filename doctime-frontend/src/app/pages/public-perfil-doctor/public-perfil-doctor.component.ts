import { Component, OnInit } from '@angular/core';
import { PerfilDoctorService } from 'src/app/services/perfil-doctor.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-public-perfil-doctor',
  templateUrl: './public-perfil-doctor.component.html',
  styleUrls: ['./public-perfil-doctor.component.scss'],
})
export class PublicPerfilDoctorComponent implements OnInit {
  doctorId!: number;

  constructor(
    public perfilDoctorSvc: PerfilDoctorService,
    private route: ActivatedRoute
  ) {
    this.doctorId = this.route.snapshot.params['id'];
  }

  ngOnInit() {
    console.log(this.doctorId);
  }
}
