import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    children: [
      {
        path: 'settings',
        loadChildren: () =>
          import('./layout/layout-patient.module').then(
            (m) => m.LayoutPatientModule
          ),
      },
      { path: '**', redirectTo: 'settings' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PatientProfileRoutingModule {}
