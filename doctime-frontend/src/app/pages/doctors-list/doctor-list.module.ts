import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoctorListRoutingModule } from './doctor-list-routing.module';
import { DoctorsComponent } from './doctors/doctors.component';
import { SharedModule } from '../../shared/shared.module';
import { FilterPipe } from './pipes/filter.pipe';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [DoctorsComponent, FilterPipe],
  imports: [
    HttpClientModule,
    CommonModule,
    DoctorListRoutingModule,
    SharedModule,
    RouterModule,
  ],
})
export class DoctorListModule {}
