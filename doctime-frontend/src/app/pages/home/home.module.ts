import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { SpecialtyCardComponent } from './components/specialty-card/specialty-card.component';
import { SpecialtyListComponent } from './components/specialty-list/specialty-list.component';
import { DoctorListComponent } from './components/doctor-list/doctor-list.component';
import { DoctorCardComponent } from './components/doctor-card/doctor-card.component';
import { OpinionCardComponent } from './components/opinion-card/opinion-card.component';
import { OpinionListComponent } from './components/opinion-list/opinion-list.component';

@NgModule({
  declarations: [
    HomeComponent,
    SpecialtyCardComponent,
    SpecialtyListComponent,
    DoctorListComponent,
    DoctorCardComponent,
    OpinionCardComponent,
    OpinionListComponent,
  ],
  imports: [CommonModule, HomeRoutingModule],
})
export class HomeModule {}
