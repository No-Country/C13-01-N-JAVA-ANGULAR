import { Component, Input } from '@angular/core';
import { Opinion } from 'src/app/shared/models/opinion.model';

@Component({
  selector: 'app-opinion-card',
  templateUrl: './opinion-card.component.html',
  styleUrls: ['./opinion-card.component.scss'],
})
export class OpinionCardComponent {
  @Input() opinion!: Opinion;
}
