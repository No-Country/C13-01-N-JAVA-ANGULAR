import { Component } from '@angular/core';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NotifyService } from 'src/app/services/notify.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { UserRegister } from 'src/app/shared/models/auth.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  public myForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
    ]),
    password2: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
    ]),
  });

  constructor(
    private notifySvc: NotifyService,
    private router: Router,
    private authSvc: AuthService
  ) {}

  onSubmit() {
    if (!this.myForm.valid) {
      this.notifySvc.showError(
        'Verifica tus datos',
        'Error al crear la cuenta'
      );
      return;
    }
    const user: UserRegister = {
      email: this.myForm.value.email ?? '',
      password: this.myForm.value.password ?? '',
      role: 'PATIENT',
    };

    this.authSvc.register(user).subscribe({
      next: () => {
        this.notifySvc.showSuccess(
          'Cuenta creada exitosamente',
          'Cuenta creada'
        );
      },
      complete: () => {
        this.router.navigate(['/doctime']);
      },
    });
  }
}
