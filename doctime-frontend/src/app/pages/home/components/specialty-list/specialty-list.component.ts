import { Component } from '@angular/core';
import { SpecialtyCardHome } from '../../../../shared/models/opinion.model';

@Component({
  selector: 'app-specialty-list',
  templateUrl: './specialty-list.component.html',
  styleUrls: ['./specialty-list.component.scss'],
})
export class SpecialtyListComponent {
  specialties: SpecialtyCardHome[] = [
    {
      icon: 'assets/images/specialties/cardiology.svg',
      title: 'Cardiología',
      description:
        'Diagnóstico y tratamiento de enfermedades cardíacas. Nuestros cardiólogos cuidan tu salud cardiovascular.',
    },
    {
      icon: 'assets/images/specialties/odontologia-1.svg',
      title: 'Odontología',
      description:
        'Cuida tu salud bucal con nuestros dentistas. Ofrecemos limpiezas dentales y más.',
    },
    {
      icon: 'assets/images/specialties/pedia.svg',
      title: 'Pediatría',
      description:
        'Atención de niños y adolescentes. Exámenes y tratamiento de enfermedades infantiles.',
    },
    {
      icon: 'assets/images/specialties/med-general.svg',
      title: 'Medicina General',
      description:
        'Cuidado médico integral para toda la familia. Confía en nuestros médicos generales para tu bienestar.',
    },
  ];
}
