import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutPatientRoutingModule } from './layout-patient-routing.module';
import { LayoutPatientComponent } from './layout-patient.component';

@NgModule({
  declarations: [LayoutPatientComponent],
  imports: [CommonModule, LayoutPatientRoutingModule],
})
export class LayoutPatientModule {}
