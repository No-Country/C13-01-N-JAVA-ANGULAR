import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { RouterModule } from '@angular/router';
import { TabsComponent } from './components/tabs/tabs.component';
import { ReservationFormComponent } from './components/reservation-form/reservation-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    TabsComponent,
    ReservationFormComponent,
  ],
  imports: [CommonModule, RouterModule, ReactiveFormsModule, HttpClientModule],
  exports: [
    HeaderComponent,
    FooterComponent,
    TabsComponent,
    ReservationFormComponent,
  ],
})
export class SharedModule {}
