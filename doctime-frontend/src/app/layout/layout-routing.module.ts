import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full',
      },
      {
        path: 'home',
        loadChildren: () =>
          import('../pages/home/home.module').then((m) => m.HomeModule),
      },
      {
        path: 'doctors',
        loadChildren: () =>
          import('../pages/doctors-list/doctor-list.module').then(
            (m) => m.DoctorListModule
          ),
      },
      {
        path: 'doctor/:id',
        loadChildren: () =>
          import(
            '../pages/public-perfil-doctor/public-perfil-doctor.module'
          ).then((m) => m.PublicPerfilDoctorModule),
      },
    ],
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LayoutRoutingModule {}
