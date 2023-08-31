import { Component } from '@angular/core';

@Component({
  selector: 'app-specialty-card',
  templateUrl: './specialty-card.component.html',
  styleUrls: ['./specialty-card.component.scss'],
})
export class SpecialtyCardComponent {
  specialties = {
    image: '../../../../../assets/images/specialties/odontologia-1.svg',
    name: 'Odontología',
    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    id: 1,
  };
}
