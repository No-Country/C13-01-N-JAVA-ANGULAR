import { Injectable } from '@angular/core';
import { CanActivate, CanMatch, Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanMatch, CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  private checkOutStatus(): boolean | Observable<boolean> {
    return this.authService.statusAuth().pipe(
      tap((isAuthenticated) => {
        if (!isAuthenticated) {
          this.authService.logout();
          this.router.navigate(['/login']);
        }
      })
    );
  }

  canMatch(): boolean | Observable<boolean> {
    return this.checkOutStatus();
  }
  canActivate(): boolean | Observable<boolean> {
    return this.checkOutStatus();
  }
}
