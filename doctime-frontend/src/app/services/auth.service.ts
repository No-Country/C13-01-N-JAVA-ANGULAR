import { Injectable } from '@angular/core';
import { Login } from '../shared/models/auth.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  apiURI = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  login(user: Login) {
    return this.http.post<Login>(`${this.apiURI}/login`, user);
  }

  register(user: Login) {
    return this.http.post<Login>(`${this.apiURI}/user/register`, user);
  }
}
