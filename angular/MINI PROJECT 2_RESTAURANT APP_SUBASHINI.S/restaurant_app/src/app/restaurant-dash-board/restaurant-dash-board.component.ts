import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

import { UserData } from '../models/userdata/userdata.module';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { Router } from '@angular/router';
import { register } from '../models/register/register.module';
import { RouterServiceService } from '../services/router-service.service';

@Component({
  selector: 'app-restaurant-dash-board',
  templateUrl: './restaurant-dash-board.component.html',
  styleUrls: ['./restaurant-dash-board.component.css']
})
export class RestaurantDashBoardComponent implements OnInit {
  formValue !: FormGroup

  userDataObj: register = new register()
  fullData: any;
  showAdd!: boolean;
  showbth!: boolean;


  constructor(private routerService: RouterServiceService, private formBuilder: FormBuilder, private restaurantService: RestaurantServiceService) { 

  }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      id: [''],

      name: [''],
      email: [''],
      mobile: [''],
      password: [''],
      type: ['']
    })
    this.getData()
  }
  clickAddResto() {
    this.formValue.reset();
    this.showAdd = true;
    this.showbth = false;
  }
  //now subscribe yte data which is mooved via service 
  addUser() {

    this.userDataObj.name = this.formValue.value.name;
    this.userDataObj.email = this.formValue.value.email;
    this.userDataObj.mobile = this.formValue.value.mobile;
    this.userDataObj.password = this.formValue.value.password;
    this.userDataObj.type = this.formValue.value.type;


    this.restaurantService.postRestaurant(this.userDataObj).subscribe(res => {
      console.log(res);
      alert("User data added successfully");
    //   let ref = document.getElementById('clear');
    //   ref?.click();

    //   this.formValue.reset()
    //   this.getData();

     },
    //   err => {
    //     alert("wrong !!!")
    //   }
    )

  }
  //get all data
  getData() {
    this.restaurantService.getRestaurant().subscribe(res => {
      this.fullData = res;
    }
    )
  }
  //delete data
  deleteUser(data: any) {
    //console.log(data)
    this.restaurantService.deleteRestaurant(data.id).subscribe(res => {
      alert("user record deleted successfully")
      // this.getData();//quick refresh data
    })

  }
  editUser(data: any) {
    this.showAdd = false;
    this.showbth = true;
     this.userDataObj.id = data.id

    this.formValue.controls['id'].setValue(data.id)
    this.formValue.controls['name'].setValue(data.name);
    this.formValue.controls['email'].setValue(data.email);
    this.formValue.controls['mobile'].setValue(data.mobile);
    this.formValue.controls['password'].setValue(data.password);
    this.formValue.controls['type'].setValue(data.type);


  }

  updateUser() {
    this.userDataObj.id=this.formValue.value.id

    this.userDataObj.name = this.formValue.value.name;
    this.userDataObj.email = this.formValue.value.email;
    this.userDataObj.mobile = this.formValue.value.mobile;
    this.userDataObj.password = this.formValue.value.password;
    this.userDataObj.type = this.formValue.value.type;
    console.log(this.userDataObj)

    this.restaurantService.updateRestaurant(this.userDataObj, this.userDataObj.id).subscribe(res => {
      alert("data updated successfully")
      // let ref = document.getElementById('clear');
      // ref?.click();


      // this.formValue.reset()
      // this.getData();

    })

  }
  foodMenu() {
    this.routerService.foodItemdisplay();

  }



}
