import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublicPerfilDoctorRoutingModule } from './public-perfil-doctor-routing.module';
import { PublicPerfilDoctorComponent } from './public-perfil-doctor.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ReservationFormComponent } from './components/reservation-form/reservation-form.component';

@NgModule({
  declarations: [PublicPerfilDoctorComponent, ReservationFormComponent],
  imports: [CommonModule, PublicPerfilDoctorRoutingModule, ReactiveFormsModule],
})
export class PublicPerfilDoctorModule {}
