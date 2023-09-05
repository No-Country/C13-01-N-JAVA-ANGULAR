import { Component } from '@angular/core';

@Component({
  selector: 'app-patient-panel',
  templateUrl: './patient-panel.component.html',
  styleUrls: ['./patient-panel.component.scss'],
})
export class PatientPanelComponent {
  getStatusColor(estado: string): string {
    switch (estado) {
      case 'Pendiente':
        return 'pending';
      case 'Atendido':
        return 'success';
      case 'Rechazado':
        return 'danger';
      default:
        return 'primary';
    }
  }
}
