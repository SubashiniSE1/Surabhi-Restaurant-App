import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { RestaurantServiceService } from '../services/restaurant-service.service';

@Injectable({
  providedIn: 'root'
})
export class CanActiveGuardGuard implements CanActivate {
  constructor(private restaurantService: RestaurantServiceService) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let name = this.restaurantService.getName();
    if (name != null) {
      return true
    }
    else {
      return false
    }

  }

}
