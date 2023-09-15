import { Component, Input } from '@angular/core';
import { SpecialtyCardHome } from '../../../../shared/models/opinion.model';

@Component({
  selector: 'app-specialty-card',
  templateUrl: './specialty-card.component.html',
  styleUrls: ['./specialty-card.component.scss'],
})
export class SpecialtyCardComponent {
  @Input() specialty!: SpecialtyCardHome;
}
