import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicPerfilDoctor } from './public-perfil-doctor.component';

const routes: Routes = [
  { path: '', component: PublicPerfilDoctor },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PublicPerfilDoctorRoutingModule {}
