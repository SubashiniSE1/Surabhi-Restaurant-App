import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { register } from '../models/register/register.module';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { UserMenuCardComponent } from '../user-menu-card/user-menu-card.component';
import { currentUser } from '../models/currentuser/currentuser.module';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  regData: register = new register;
  currentuser: currentUser = new currentUser

  constructor(private restaurantService: RestaurantServiceService,
    private _http: HttpClient, private router: Router,) {

    this.currentuser.id = 0;
    this.currentuser.name = "";
    this.restaurantService.deleteCuser(1, this.currentuser)
  }
  regArray: Array<register> = [];

  loginForm = new FormGroup(
    {
      userName: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
      //Validators.pattern('[0-9]*')
    }
  )

  ngOnInit(): void {

  }

  //login method
 async  login() {
    console.log(this.loginForm.value.userName)
    this.regData.name = this.loginForm.value.userName;
    this.regData.password = this.loginForm.value.password;
    this.restaurantService.getLogin().subscribe(res => {
      console.log(res)
      console.log(this.regData)
      console.log(res.length)



      for (let i = 0; i < res.length; i++) {

        console.log(this.regData.name)
        if (res[i].name === this.regData.name && res[i].password === this.regData.password) {
          console.log("login ..........." + res[i].name)

          console.log(res[i].password)
          if (this.regData.name === "Admin") {
            console.log(res[i].name)
            this.router.navigate(['RestaurantDashBoard'])
          } else {
            this.currentuser.id = 1
            this.currentuser.customerId = res[i].id
            this.currentuser.name = this.regData.name;
            this.restaurantService.setCuserName(this.currentuser).subscribe(res => {
              console.log("navigate to menu page.......")
              this.restaurantService.storeName(this.regData.name)
              this.router.navigate(['viewMenuCardpage'])
            })
          }
          
        }
      }
    });

    

  }
  getUserName() {
    return this.loginForm.get('username');
  }
  getPassword() {
    return this.loginForm.get('password');
  }
  
  getUserNameErrorMsg() {
    if (this.getUserName()?.invalid && (this.getUserName()?.dirty || this.getUserName()?.touched)) {
      return "User Name should not be blank"
    } else {
      return "";
    }
  }
  getPasswordErrorMsg() {
    if (this.getPassword()?.invalid && (this.getPassword()?.dirty || this.getPassword()?.touched)) {
      if (this.getPassword()?.hasError('required')) {
        return "Password can not be blank"
      }
      else if (this.getPassword()?.hasError('minlength')) {
        return "Password can not be less the 6 characters"
      }
    
      
      else {
        return ""
      }
    } else {
      return ""
    }
  }

}
