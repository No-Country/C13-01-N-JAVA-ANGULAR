import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-layout-doctor',
  templateUrl: './layout-doctor.component.html',
  styleUrls: ['./layout-doctor.component.scss'],
})
export class LayoutDoctorComponent {
  constructor(
    private authSvc: AuthService,
    private router: Router
  ) {}

  logout() {
    this.authSvc.logout();
    this.router.navigate(['/doctime']);
  }
}
