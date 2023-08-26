import { Component } from '@angular/core';

@Component({
  selector: 'app-layout-login',
  templateUrl: './layout-login.component.html',
  styleUrls: ['./layout-login.component.scss'],
})
export class LayoutLoginComponent {
  email = '';
  password = '';

  login() {
    // Aquí puedes implementar la lógica de autenticación
    // por ejemplo, enviar los datos al servidor, etc.
    // En caso de usuario no registrado, puedes mostrar una alerta.
    // if (!usuarioRegistrado) {
    //   alert('Usuario no registrado.');
    // }
  }
}
