import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { DoctorRegister } from 'src/app/shared/models/auth.model';
import { CustomValidators } from 'src/app/shared/validators/custom.validators';
import { NotifyService } from '../../../../services/notify.service';

export enum RequiredMessages {
  name = 'El nombre es requerido',
  lastname = 'El apellido es requerido',
  email = 'El e-mail es requerido',
  password = 'La contraseña es requerida',
  address = 'La dirección es requerida',
  city = 'La ciudad es requerida',
  phone = 'El teléfono es requerido',
  paymentTypes = 'Debes seleccionar al menos un método de pago',
  specialty = 'Debes seleccionar una especialidad',
  passwordConfirm = 'La confirmación de contraseña es requerida',
  email_hasError_email = 'Dirección de e-mail incorrecta',
  password_hasError_requirements = 'La contraseña debe tener al menos 6 caracteres, una letra mayúscula y un número',
  passwordConfirm_hasError_requirements = 'La contraseña debe tener al menos 6 caracteres, una letra mayúscula y un número',
}

@Component({
  selector: 'app-register-doctor',
  templateUrl: './register-doctor.component.html',
  styleUrls: ['./register-doctor.component.scss'],
})
export class RegisterDoctorComponent {
  constructor(
    private authService: AuthService,
    private router: Router,
    private notifyService: NotifyService
  ) {}

  public registerDoctorForm: FormGroup = new FormGroup(
    {
      name: new FormControl('', [Validators.required]),
      lastname: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
      passwordConfirm: new FormControl('', [Validators.required]),
      specialty: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      city: new FormControl('', [Validators.required]),
      paymentTypes: new FormControl('', [Validators.required]),
    },
    {
      validators: [CustomValidators.passwordsMatching],
    }
  );

  get f() {
    return this.registerDoctorForm;
  }

  public registerDoctor(): void {
    if (!this.registerDoctorForm.valid) {
      this.notifyService.showError(
        'No se pudo registrar',
        'Verifica los campos'
      );
      return this.f.markAllAsTouched();
    }

    const doctor: DoctorRegister = {
      name: this.f.get('name')?.value,
      lastname: this.f.get('lastname')?.value,
      email: this.f.get('email')?.value,
      password: this.f.get('password')?.value,
      specialty: this.f.get('specialty')?.value,
      phone: this.f.get('phone')?.value,
      address: `${this.f.get('address')?.value}, ${this.f.get('city')?.value}`,
      paymentTypes: this.f.get('paymentTypes')?.value,
      role: 'DOCTOR',
    };

    this.authService.register(doctor).subscribe({
      next: () => {
        this.notifyService.showSuccess('Registro exitoso', '');
        this.router.navigate(['/dashboard']);
      },
      error: () => {
        this.notifyService.showError(
          'No se pudo registrar',
          'Intenta de nuevo'
        );
      },
    });
  }

  isRequired(controlName: string): string {
    return this.f.get(controlName)?.hasError('required')
      ? RequiredMessages[controlName as keyof typeof RequiredMessages]
      : '';
  }
  hasError(input: string, validatorError: string) {
    return this.f.get(input)?.hasError(validatorError)
      ? RequiredMessages[
          `${input}_hasError_${validatorError}` as keyof typeof RequiredMessages
        ]
      : this.isRequired(input);
  }

  checkValidation(input: string): boolean | undefined {
    const validation =
      this.f.get(input)?.invalid &&
      (this.f.get(input)?.dirty || this.f.get(input)?.touched);
    return validation;
  }
}
