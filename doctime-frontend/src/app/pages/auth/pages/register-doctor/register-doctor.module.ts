import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterDoctorRoutingModule } from './register-doctor-routing.module';
import { RegisterDoctorComponent } from './register-doctor.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [RegisterDoctorComponent],
  imports: [
    CommonModule,
    RegisterDoctorRoutingModule,
    SharedModule,
    ReactiveFormsModule,
  ],
})
export class RegisterDoctorModule {}
