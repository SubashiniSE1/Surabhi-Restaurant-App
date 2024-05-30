import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { register} from '../models/register/register.module';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registrationForm!: FormGroup
  userDataObject: register = new register;

  constructor(private formBuilder: FormBuilder,private _http:HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.registrationForm=this.formBuilder.group({
    name:[''],
    email:[''],
    mobile:[''],
    password:[''],
    type:['']

  })
}

//make method to create user
register(){


  this.userDataObject.name = this.registrationForm.value.name;
  this.userDataObject.email = this.registrationForm.value.email;
  this.userDataObject.mobile= this.registrationForm.value.mobile;
  this.userDataObject.password = this.registrationForm.value.password;
  this.userDataObject.type= this.registrationForm.value.type;
  console.log(this.userDataObject)
  console.log(this.registrationForm)
   


  this._http.post<register>("http://localhost:3000/register",this.userDataObject).subscribe(res=>{
    
    alert("registration successfully ");
    this.registrationForm.reset();
    this.router.navigate(['login'])

  },err=>{
    alert("register again!")
  }
  )

}

}
