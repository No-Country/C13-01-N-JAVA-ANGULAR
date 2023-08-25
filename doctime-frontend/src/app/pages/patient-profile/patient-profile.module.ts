import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientProfileRoutingModule } from './patient-profile-routing.module';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { SettingsComponent } from './components/settings/settings.component';

import { SeguridadComponent } from './components/seguridad/seguridad.component';

@NgModule({
  declarations: [AppointmentsComponent, SettingsComponent, SeguridadComponent],
  imports: [CommonModule, PatientProfileRoutingModule],
})
export class PatientProfileModule {}
