import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { NotifyService } from '../../../services/notify.service';

@Component({
  selector: 'app-layout-patient',
  templateUrl: './layout-patient.component.html',
  styleUrls: ['./layout-patient.component.scss'],
})
export class LayoutPatientComponent {
  constructor(
    private authSvc: AuthService,
    private router: Router,
    private notifySvc: NotifyService
  ) {}

  logout() {
    this.authSvc.logout();
    this.notifySvc.showSuccess('Hasta luego', 'Sesión cerrada');
    this.router.navigate(['/login']);
  }
}
