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
    console.log(this.email, this.password);
  }
}
