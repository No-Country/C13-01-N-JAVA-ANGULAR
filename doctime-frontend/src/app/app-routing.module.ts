import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'doctime', pathMatch: 'full' },
  {
    path: 'auth',
    loadChildren: () =>
      import('./pages/auth/auth.module').then((m) => m.AuthModule),
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
      import('./pages/auth/pages/register/register.module').then(
        (m) => m.RegisterModule
      ),
  },
  {
    path: 'public-perfil-doctor',
    loadChildren: () =>
      import('./pages/public-perfil-doctor/public-perfil-doctor.module').then(
        (m) => m.PublicPerfilDoctorModule
      ),
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
  { path: '**', redirectTo: 'doctime' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
