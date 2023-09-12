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

    private router: Router
  ) {}

  /* asyncmailValidator(control: FormControl) {
    return new Promise((resolve) => {
      setTimeout(() => {
        if (control.value === 'correo@correo.com') {
          resolve({ exists: true });
        } else {
          resolve(null);
        }
      }, 1000)
    });
  }
 */
  /* isValidField(field: string) { } */

  onSubmit() {
    this.myForm.markAllAsTouched();
    console.log(this.myForm.value);

    if (this.myForm.valid) {
      this.notifySvc.toastrSvc.success(
        'Seras redirigido al login',
        'Cuenta creada'
      );
      setTimeout(() => {
        this.router.navigate(['/login']);
      }, 5000);
    } else if (!this.myForm.valid) {
      this.notifySvc.toastrSvc.error(
        'Verifica tus datos',
        'Error al crear la cuenta'
      );
    }
    this.myForm.reset();
  }
}
