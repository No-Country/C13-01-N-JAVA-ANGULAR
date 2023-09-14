import { Component } from '@angular/core';

@Component({
  selector: 'app-opinion-card',
  templateUrl: './opinion-card.component.html',
  styleUrls: ['./opinion-card.component.scss'],
})
export class OpinionCardComponent {
  opinion = {
    avatar: '../../../../../assets/images/avatar/patient-1.jpg',
    name: 'Jhon Doe',
    text: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum.',
    rol: 'Paciente',
  };
}
