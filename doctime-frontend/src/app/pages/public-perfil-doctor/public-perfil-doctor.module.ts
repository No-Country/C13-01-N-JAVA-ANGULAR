import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublicPerfilDoctorRoutingModule } from './public-perfil-doctor-routing.module';
import { PublicPerfilDoctor } from './public-perfil-doctor.component';

@NgModule({
  declarations: [PublicPerfilDoctor],
  imports: [CommonModule, PublicPerfilDoctorRoutingModule],
})
export class PublicPerfilDoctorModule {}
