import { Component } from '@angular/core';
import { Opinion } from 'src/app/shared/models/opinion.model';

@Component({
  selector: 'app-opinion-list',
  templateUrl: './opinion-list.component.html',
  styleUrls: ['./opinion-list.component.scss'],
})
export class OpinionListComponent {
  opinions: Opinion[] = [
    {
      avatar: 'assets/images/avatar/patient-1.jpg',
      name: 'Dr. Ana',
      last_name: 'González',
      text: 'DocTime ha transformado la forma en que gestiono mis citas médicas. Es una plataforma intuitiva y eficiente que me permite conectar con pacientes y ofrecerles una atención de calidad. Estoy encantada de ser parte de esta comunidad médica en línea.',
      rol: 'Médico General',
    },
    {
      avatar: 'assets/images/avatar/patient-2.jpg',
      name: 'Laura',
      last_name: 'Martínez',
      text: '¡DocTime ha sido un salvavidas para mí y mi familia! Encontrar al médico adecuado y programar citas nunca ha sido tan fácil. Recomiendo encarecidamente DocTime a todos los que buscan atención médica de calidad.',
      rol: 'Paciente Satisfecha',
    },
  ];
}
