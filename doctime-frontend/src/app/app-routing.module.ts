import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'doctime', pathMatch: 'full' },
  {
    path: 'login',
    loadChildren: () =>
      import('./pages/login/login.module').then((m) => m.LoginModule),
  },

  {
    path: 'profile',
    loadChildren: () =>
      import('./pages/patient-profile/patient-profile.module').then(
        (m) => m.PatientProfileModule
      ),
    canMatch: [AuthGuard],
  },
  {
    path: 'register',
    loadChildren: () =>
      import('./pages/register/register.module').then((m) => m.RegisterModule),
  },
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./pages/doctor-profile/doctor-profile.module').then(
        (m) => m.DoctorProfileModule
      ),
    canActivate: [AuthGuard],
  },
  {
    path: 'doctime',
    loadChildren: () =>
      import('./layout/layout.module').then((m) => m.LayoutModule),
  },
  {
    path: 'reservation',
    loadChildren: () =>
      import('./pages/reservation/reservation.module').then(
        (m) => m.ReservationModule
      ),
  },
  { path: '**', redirectTo: 'doctime' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
