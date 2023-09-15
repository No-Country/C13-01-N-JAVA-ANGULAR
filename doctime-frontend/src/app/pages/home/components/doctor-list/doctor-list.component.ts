import { Component } from '@angular/core';
import { DoctorCardHome } from 'src/app/shared/models/doctors.model';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.scss'],
})
export class DoctorListComponent {
  doctors: DoctorCardHome[] = [
    {
      name: 'Dr. John',
      last_name: 'Doe',
      specialty: 'Cardiologo',
      image: 'assets/images/doctors/bruno-rodrigues.jpg',
    },
    {
      name: 'Dra. Maria',
      last_name: 'Doe',
      specialty: 'Odontólogo',
      image: 'assets/images/doctors/doctor-2.jpg',
    },
    {
      name: 'Dr. Jane',
      last_name: 'Doe',
      specialty: 'Neurólogo',
      image: 'assets/images/doctors/doctor-3.jpg',
    },
    {
      name: 'Dr. John',
      last_name: 'Doe',
      specialty: 'Cardiólogo',
      image: 'assets/images/doctors/doctor-4.jpg',
    },
  ];
}
