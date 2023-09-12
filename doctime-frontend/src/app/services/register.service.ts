import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private readonly http: HttpClient) {}

  register(email: string, password: string, password2: string) {
    return this.http.post('http://localhost:8080/doctime/register', {
      email,
      password,
      password2,
    });
  }
}
