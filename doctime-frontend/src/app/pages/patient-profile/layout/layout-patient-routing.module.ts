import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPatientComponent } from './layout-patient.component';
import { AppointmentsComponent } from '../components/appointments/appointments.component';
import { SettingsComponent } from '../components/settings/settings.component';
import { SeguridadComponent } from '../components/seguridad/seguridad.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutPatientComponent,
    children: [
      { path: '', redirectTo: 'appointments', pathMatch: 'full' },
      { path: 'settings', component: SettingsComponent },
      { path: 'appointments', component: AppointmentsComponent },
      { path: 'security', component: SeguridadComponent },
      // TODO: add routes here
      { path: '**', redirectTo: 'settings' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LayoutPatientRoutingModule {}
