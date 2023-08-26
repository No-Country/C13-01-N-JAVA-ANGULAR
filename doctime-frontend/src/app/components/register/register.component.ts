import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  public myForm: FormGroup = this.fb.group({
    name: ['', [Validators.required], Validators.minLength(3)],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    password2: ['', [Validators.required, Validators.minLength(6)]],
  });

  constructor(private fb: FormBuilder) {}

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
  }
}
