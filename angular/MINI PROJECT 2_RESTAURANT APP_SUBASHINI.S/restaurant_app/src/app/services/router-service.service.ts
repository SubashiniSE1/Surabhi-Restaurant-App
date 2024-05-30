import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterServiceService {

  constructor(private router:Router) { }

  todayBill(){
    this.router.navigate(['generatetodayBillPage'])

  }

  monthlyBill(){
    this.router.navigate(['generateMonthlyBillPage'])

  }

  foodItemdisplay(){
    this.router.navigate(['MenuCardpage'])
  }

  homeLogin(){
    this.router.navigate(['login'])
  }

  homeSignUp(){
    this.router.navigate(['register'])
  }

  homePage(){
    this.router.navigate(['homePage'])
  }


  cartPage(){
    this.router.navigate(['yourCart'])
  }

  

  
}
