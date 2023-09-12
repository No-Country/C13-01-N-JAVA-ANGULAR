import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutLoginComponent } from './layout-login.component';
import { LoginRoutingModule } from './login-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [LayoutLoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [AuthService],
})
export class LoginModule {}
