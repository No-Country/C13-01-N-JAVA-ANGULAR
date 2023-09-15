import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  DoctorRegister,
  ResAuth,
  UserLogin,
  UserRegister,
} from '../shared/models/auth.model';
import { Observable, of, tap, map, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080';
  public id?: number;
  public token?: string;

  constructor(private http: HttpClient) {}

  get currentUserId() {
    if (!this.id) return undefined;
    return this.id;
  }

  decodeToken(token: string) {
    const payload = token.split('.')[1];
    const decodedPayload = atob(payload);
    const data = JSON.parse(decodedPayload);
    this.id = data.id;
  }

  login(user: UserLogin): Observable<ResAuth> {
    return this.http.post<ResAuth>(`${this.apiUrl}/login`, user).pipe(
      tap((res) => {
        this.id = res.id;
        localStorage.setItem('id', res.id.toString());
      }),
      tap((res) => {
        this.token = res.token;
        localStorage.setItem('token', res.token);
      })
    );
  }

  register(user: UserRegister | DoctorRegister): Observable<ResAuth> {
    return this.http.post<ResAuth>(`${this.apiUrl}/user/register`, user).pipe(
      tap((res) => {
        this.id = res.id;
        localStorage.setItem('id', res.id.toString());
      }),
      tap((res) => {
        this.token = res.token;
        localStorage.setItem('token', res.token);
      })
    );
  }

  statusAuth(): Observable<boolean> {
    if (localStorage.getItem('token')) return of(true);

    const token = localStorage.getItem('token');

    return this.http
      .get<ResAuth>(`${this.apiUrl}/user/${this.id}`, {
        headers: { Authorization: `Bearer ${token}` },
      })
      .pipe(
        tap((res) => (this.id = res.id)),
        map((res) => !!res.id),
        catchError(() => of(false))
      );
  }

  logout() {
    this.id = undefined;
    this.token = undefined;
    localStorage.clear();
  }
}
