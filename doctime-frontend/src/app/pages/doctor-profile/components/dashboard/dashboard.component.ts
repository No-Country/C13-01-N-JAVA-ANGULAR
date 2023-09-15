import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
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
