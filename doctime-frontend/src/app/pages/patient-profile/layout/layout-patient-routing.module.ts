import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutPatientComponent } from './layout-patient.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutPatientComponent,
    children: [
      { path: '', redirectTo: 'appoiment', pathMatch: 'full' },
      // TODO: add routes here
      { path: '**', redirectTo: 'appoiment' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LayoutPatientRoutingModule {}
