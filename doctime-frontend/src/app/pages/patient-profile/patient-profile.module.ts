import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientProfileRoutingModule } from './patient-profile-routing.module';
import { AppointmentsComponent } from './components/appointments/appointments.component';

@NgModule({
  declarations: [AppointmentsComponent],
  imports: [CommonModule, PatientProfileRoutingModule],
})
export class PatientProfileModule {}
