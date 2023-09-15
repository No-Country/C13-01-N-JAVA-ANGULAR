import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublicPerfilDoctorRoutingModule } from './public-perfil-doctor-routing.module';
import { PublicPerfilDoctorComponent } from './public-perfil-doctor.component';

@NgModule({
  declarations: [PublicPerfilDoctorComponent],
  imports: [CommonModule, PublicPerfilDoctorRoutingModule],
})
export class PublicPerfilDoctorModule {}
