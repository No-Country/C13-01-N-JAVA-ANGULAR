import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    children: [
      {
        path: 'doctor',
        loadChildren: () =>
          import('./layout/layout-doctor.module').then(
            (m) => m.LayoutDoctorModule
          ),
      },
      { path: '**', redirectTo: 'doctor' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DoctorProfileRoutingModule {}
