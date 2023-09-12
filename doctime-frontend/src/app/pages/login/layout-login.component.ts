import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { NotifyService } from 'src/app/services/notify.service';
import { UserLogin } from 'src/app/shared/models/auth.model';

@Component({
  selector: 'app-layout-login',
  templateUrl: './layout-login.component.html',
  styleUrls: ['./layout-login.component.scss'],
})
export class LayoutLoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required]),
  });

  constructor(
    private authSvc: AuthService,
    private notifySvc: NotifyService
  ) {}

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }

  login() {
    const email = this.email?.value;
    const password = this.password?.value;

    if (!email || !password) {
      this.notifySvc.toastrSvc.error(
        'Verifica tus datos',
        'Error al iniciar sesión'
      );
      return;
    }

    const user: UserLogin = {
      email,
      password,
    };

    this.authSvc.login(user).subscribe({
      next: (res) => {
        this.notifySvc.toastrSvc.success(
          'Bienvenido',
          'Inicio de sesión exitoso'
        );
        console.log(res);
      },
    });
  }
}
