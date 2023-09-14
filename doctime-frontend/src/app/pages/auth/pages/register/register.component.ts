import { Component } from '@angular/core';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NotifyService } from 'src/app/services/notify.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { UserRegister } from 'src/app/shared/models/auth.model';
import { CustomValidators } from 'src/app/shared/validators/custom.validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  public myForm = new FormGroup(
    {
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z0-9]{8,}$/),
      ]),
      passwordConfirm: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    },
    {
      validators: [CustomValidators.passwordsMatching],
    }
  );

  constructor(
    private notifySvc: NotifyService,
    private authSvc: AuthService,

    private router: Router
  ) {}

  onSubmit() {
    console.log(this.myForm.value);
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
        this.notifySvc.showSuccess(
          'Has Iniciado Sesión',
          'Disfruta de la plataforma'
        );
      },
      complete: () => {
        this.router.navigate(['/doctime']);
      },
    });
  }
}
