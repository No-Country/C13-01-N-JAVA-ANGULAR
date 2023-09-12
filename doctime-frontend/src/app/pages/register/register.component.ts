import { Component } from '@angular/core';

import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { NotifyService } from 'src/app/services/notify.service';
import { Router } from '@angular/router';
import { Register } from 'src/app/models/auth.interface';
import { AuthService } from 'src/app/services/auth.service';

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
    private fb: FormBuilder,
    private notifySvc: NotifyService,
    private toastr: ToastrService,
    private router: Router,
    private authSvc: AuthService
  ) {}

  onSubmit() {
    console.log(this.myForm.value);
    if (!this.myForm.valid) {
      this.notifySvc.toastrSvc.error(
        'Verifica tus datos',
        'Error al crear la cuenta'
      );
      return;
    }
    const user: Register = {
      email: this.myForm.value.email ?? '',
      password: this.myForm.value.password ?? '',
      role: 'PATIENT',
    };

    this.authSvc.register(user).subscribe({
      next: (res) => {
        this.toastr.success('Usuario creado', 'Registro exitoso');
        console.log(res);
      },
    });
    this.myForm.reset();
  }
}
