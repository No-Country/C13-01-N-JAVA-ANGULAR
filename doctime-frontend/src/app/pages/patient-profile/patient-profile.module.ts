import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientProfileRoutingModule } from './patient-profile-routing.module';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { SettingsComponent } from './components/settings/settings.component';

@NgModule({
  declarations: [AppointmentsComponent, SettingsComponent],
  imports: [CommonModule, PatientProfileRoutingModule],
})
export class PatientProfileModule {}
