import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutLoginComponent } from './layout-login/layout-login.component';
import { LoginRoutingModule } from './login-routing.module';

@NgModule({
  declarations: [LayoutLoginComponent],
  imports: [CommonModule, LoginRoutingModule],
})
export class LoginModule {}
