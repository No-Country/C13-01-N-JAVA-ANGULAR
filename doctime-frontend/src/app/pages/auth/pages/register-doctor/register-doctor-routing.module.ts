import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterDoctorComponent } from './register-doctor.component';

const routes: Routes = [
  {
    path: '',
    component: RegisterDoctorComponent,
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RegisterDoctorRoutingModule {}
