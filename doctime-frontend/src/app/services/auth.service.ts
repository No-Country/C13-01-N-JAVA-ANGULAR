import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin, UserRegister } from '../shared/models/auth.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}
  private apiUrl = 'http://localhost:8080';

  login(user: UserLogin) {
    return this.http.post<UserLogin>(`${this.apiUrl}/login`, user);
  }

  register(user: UserRegister) {
    return this.http.post(`${this.apiUrl}/user/register`, user);
  }
}
