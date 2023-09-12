import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorProfileRoutingModule } from './doctor-profile-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ScheduleComponent } from './components/schedule/schedule.component';
import { PatientPanelComponent } from './components/patient-panel/patient-panel.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [
    DashboardComponent,
    ProfileComponent,
    ScheduleComponent,
    PatientPanelComponent,
  ],
  imports: [CommonModule, DoctorProfileRoutingModule, SharedModule],
})
export class DoctorProfileModule {}
