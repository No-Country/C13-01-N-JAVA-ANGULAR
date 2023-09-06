import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutDoctorRoutingModule } from './layout-doctor-routing.module';
import { LayoutDoctorComponent } from './layout-doctor.component';

@NgModule({
  declarations: [LayoutDoctorComponent],
  imports: [CommonModule, LayoutDoctorRoutingModule],
})
export class LayoutDoctorModule {}
