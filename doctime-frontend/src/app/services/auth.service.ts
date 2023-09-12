import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../models/auth.interface';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private readonly http: HttpClient) {}
  private apiUrl = 'http://localhost:8080';

  register(user: Register) {
    return this.http.post(`${this.apiUrl}/user/register`, user);
  }
}
