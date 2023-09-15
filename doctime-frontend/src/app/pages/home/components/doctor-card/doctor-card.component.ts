import { Component, Input } from '@angular/core';
import { DoctorCardHome } from '../../../../shared/models/doctors.model';

@Component({
  selector: 'app-doctor-card',
  templateUrl: './doctor-card.component.html',
  styleUrls: ['./doctor-card.component.scss'],
})
export class DoctorCardComponent {
  @Input() doctor!: DoctorCardHome;
}
