import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Login } from 'src/app/shared/models/auth.model';

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

  private authService = inject(AuthService);

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
      return;
    }

    const user: Login = {
      email,
      password,
    };

    this.authService.login(user).subscribe((res) => {
      console.log(res);
    });
  }
}
