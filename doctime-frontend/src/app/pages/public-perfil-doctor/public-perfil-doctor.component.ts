import { Component, OnInit } from '@angular/core';
import { PerfilDoctorService } from 'src/app/services/perfil-doctor.service';
import { UserRegister } from 'src/app/shared/models/auth.model';
import { DoctorRegister, User } from '../../shared/models/auth.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-public-perfil-doctor',
  templateUrl: './public-perfil-doctor.component.html',
  styleUrls: ['./public-perfil-doctor.component.scss'],
})
export class PublicPerfilDoctor implements OnInit {
  doctor: any;

  constructor(
    public perfilDoctorSvc: PerfilDoctorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Implementar lógica de inicialización

    const DoctorId = this.route.snapshot.paramMap.get('id');
    this.perfilDoctorSvc.getDoctorById(this.doctor.id).subscribe((data) => {
      this.doctor = data;
    });

    console.log(this.doctor.id);
  }
}
