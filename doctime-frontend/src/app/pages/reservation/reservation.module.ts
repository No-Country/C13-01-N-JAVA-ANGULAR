import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ReservationComponent } from './reservation.component';
import { ReservaRoutingModule } from './reservation-routing.module';
import { ScheduleComponent } from './components/schedule/schedule.component';

@NgModule({
  declarations: [ReservationComponent, ScheduleComponent],
  imports: [CommonModule, ReservaRoutingModule, FormsModule],
})
export class ReservationModule {}
