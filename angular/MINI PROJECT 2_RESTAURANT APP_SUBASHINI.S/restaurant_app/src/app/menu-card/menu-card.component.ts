import { Component, OnInit } from '@angular/core';
import { Menu } from '../models/food-items/food-items.module';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RestaurantServiceService } from '../services/restaurant-service.service';

import { RouterServiceService } from '../services/router-service.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.component.html',
  styleUrls: ['./menu-card.component.css']
})
export class MenuCardComponent implements OnInit {

  formValue !: FormGroup
  menuObject: Menu = new Menu;
  showAdd!: boolean;
  showbth!: boolean;
  selectedFile: File | any = null;


  foodItems: Array<Menu> = [];

  constructor(private restaurantService: RestaurantServiceService, private formBuilder: FormBuilder,
    private routerService: RouterServiceService, private http: HttpClient) {

    restaurantService.getFoodItems().subscribe(res => {
      const res1 = res.map(data => {

        return {
          id: data.id,
          name: data.name,
          description: data.description,
          cuisine_name: data.cuisine_name,
          consumable: data.consumable,
          price: data.price,
          catagory_name: data.category_name,
          images: data.images,


        }
      })

      this.foodItems = [...res];
    })
  }


  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      id: [''],
      name: [''],
      description: [''],
      category_name: [''],
      cuisine_name: [''],
      price: [''],
      consumable: [''],
      images: ['']



    })
  }
  clickAddResto() {
    this.formValue.reset();
    this.showAdd = true;
    this.showbth = false;
  }

  addMenu() {
    this.menuObject.id = this.formValue.value.id
    this.menuObject.name = this.formValue.value.name
    this.menuObject.description = this.formValue.value.description
    this.menuObject.category_name = this.formValue.value.category_name
    this.menuObject.cuisine_name = this.formValue.value.cuisine_name
    this.menuObject.price = this.formValue.value.price
    this.menuObject.consumable = this.formValue.value.consumable
    this.menuObject.images = this.formValue.value.images

    this.restaurantService.addFoodItems(this.menuObject).subscribe(res => {
      console.log(res);
      alert("Food Item  added successfully");
      let ref = document.getElementById('clear');
      ref?.click();
    })


  }
  getFoodItem() {
    this.restaurantService.getFoodItem().subscribe(res => {
      console.log(res)

    }
    )
  }

  deleteItem(data: any) {
    this.restaurantService.deleteFoodItem(data.id).subscribe(res => {
      alert("Food Item  deleted successfully")

    })

  }

  editItem(data: any) {
    this.showAdd = false;
    this.showbth = true;

    this.formValue.controls['id'].setValue(data.id)
    this.formValue.controls['name'].setValue(data.name);
    this.formValue.controls['description'].setValue(data.description);
    this.formValue.controls['category_name'].setValue(data.category_name);
    this.formValue.controls['cuisine_name'].setValue(data.cuisine_name);
    this.formValue.controls['price'].setValue(data.price);
    this.formValue.controls['consumable'].setValue(data.consumable);
    this.formValue.controls['images'].setValue(data.images);

  }

  updateMenu() {

    this.menuObject.id = this.formValue.value.id;
    this.menuObject.name = this.formValue.value.name;
    this.menuObject.description = this.formValue.value.description;
    this.menuObject.category_name = this.formValue.value.catagory_name;
    this.menuObject.consumable = this.formValue.value.consumable;
    this.menuObject.cuisine_name = this.formValue.value.cuisine_name;
    this.menuObject.price = this.formValue.value.price;

    this.restaurantService.updateItems(this.menuObject, this.menuObject.id).subscribe(res => {
      alert("Food Item  updated successfully")
      let ref = document.getElementById('clear');
      ref?.click();


      this.formValue.reset()
    })

  }
  generateTodayBill() {
    this.routerService.todayBill();
  }

  generateMonthlyBill() {
    this.routerService.monthlyBill();
  }
}


