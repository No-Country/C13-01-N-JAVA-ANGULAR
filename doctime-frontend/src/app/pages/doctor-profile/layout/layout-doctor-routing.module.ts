import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutDoctorComponent } from './layout-doctor.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { PatientPanelComponent } from '../components/patient-panel/patient-panel.component';
import { ProfileComponent } from '../components/profile/profile.component';
import { ScheduleComponent } from '../components/schedule/schedule.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutDoctorComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'home', component: DashboardComponent },
      { path: 'patient-panel', component: PatientPanelComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'schedule', component: ScheduleComponent },
      { path: '**', redirectTo: 'home' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LayoutDoctorRoutingModule {}
