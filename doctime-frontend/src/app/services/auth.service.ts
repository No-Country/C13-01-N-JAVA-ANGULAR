import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  ResLogin,
  ResRegister,
  UserLogin,
  UserRegister,
} from '../shared/models/auth.model';
import { Observable, of, tap, map, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}
  private apiUrl = 'http://localhost:8080';
  private id?: number;
  public token?: string;

  get currentUser() {
    if (!this.id) return undefined;
    return structuredClone(this.id);
  }

  login(user: UserLogin): Observable<ResLogin> {
    return this.http.post<ResLogin>(`${this.apiUrl}/login`, user).pipe(
      tap((res) => {
        console.log(res);
        this.id = res.id;
      }),
      tap((res) => {
        this.token = res.token;
        localStorage.setItem('token', res.token);
      })
    );
  }

  register(user: UserRegister): Observable<ResRegister> {
    return this.http
      .post<ResRegister>(`${this.apiUrl}/user/register`, user)
      .pipe(
        tap((res) => {
          this.id = res.id;
        }),
        tap((res) => {
          this.token = res.accessToken;
          localStorage.setItem('token', res.accessToken);
        })
      );
  }

  statusAuth(): Observable<boolean> {
    if (localStorage.getItem('token')) return of(true);

    const token = localStorage.getItem('token');

    return this.http
      .get<ResLogin>(`${this.apiUrl}/user/${this.id}`, {
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
