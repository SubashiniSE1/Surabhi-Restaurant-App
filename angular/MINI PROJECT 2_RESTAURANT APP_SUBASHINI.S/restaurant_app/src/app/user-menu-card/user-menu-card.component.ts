import { Component, OnInit } from '@angular/core';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { Menu } from '../models/food-items/food-items.module';
import { FormGroup, FormBuilder } from '@angular/forms';
import { foodOrders } from '../models/food-orders/food-orders.module';
import { register } from '../models/register/register.module';
import { customerOrder } from '../models/customer-order/customer-order.module';
import { Router } from '@angular/router';

import { RouterServiceService } from '../services/router-service.service';



//import { GenerateBillComponent } from '../generate-bill/generate-bill.component';


@Component({
  selector: 'app-user-menu-card',
  templateUrl: './user-menu-card.component.html',
  styleUrls: ['./user-menu-card.component.css']
})

export class UserMenuCardComponent implements OnInit {
  formValue !: FormGroup
  formValue1 !: FormGroup
  orderValue!: FormGroup
  order: foodOrders = new foodOrders();
  ordersArray: Array<foodOrders> = [];
  totalPrice: number = 0;
  user: register = new register()
  custOrder: customerOrder = new customerOrder();
  custorders: Array<customerOrder> = [];

  // gBill : new GenerateBillComponent(restaurantService)
  foodItems: Array<Menu> = [];
  constructor(private restaurantService: RestaurantServiceService,
    private formBuilder: FormBuilder,
    private router: Router, private routerService: RouterServiceService) {
    let dt = new Date
    console.log(dt.getMonth())
    console.log(this.order.totalPrice)
    this.restaurantService.checkUser().subscribe(resp => {
      this.user.name = resp.name
      this.user.id=resp.customerId
    })

    this.order.totalPrice = 0
    this.totalPrice = 0
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
      price: [''],
      quantity: [''],
      totalPrice: [''],
    })

    this.formValue1 = this.formBuilder.group({

      quantity1: ['']
    })

  }

  getFoodItem() {
    console.log("setting food item")
    this.restaurantService.getFoodItem().subscribe(res => {
      // this.fullData = res;
    }
    )
  }

  orderItems(menu: Menu) {
    this.order.totalPrice = 0
    console.log(menu.id)
    this.formValue.controls['id'].setValue(menu.id);
    this.formValue.controls['name'].setValue(menu.name);
    this.formValue.controls['price'].setValue(menu.price);
    this.formValue.controls['quantity'].setValue(menu.quantity);


    //seting values
    this.order.id = menu.id
    this.order.name = menu.name
    this.order.price = menu.price
this.order.images=menu.images
    // console.log(this.order)

  }
addToCart(){
  console.log("adding to cart")
  
  
  let empty: customerOrder[]=[]
  console.log("getordernyid calling before")
  this.restaurantService.getOrderById( this.user.id).subscribe((resparray)=>{
    console.log("getordernyid calling after")
    if(resparray!=empty){
      let newOrder = true
      // console.log("resp is not null")
    console.log(resparray)//
              for(let j=0;j<resparray.length;j++){ //iterating each order
               console.log("checking")
                  let res = resparray[j]
                          // resp.forEach(res => {
                        // if(counter==fal)
                  console.log(res.UserId )
                  console.log(this.user.id)
                  if(res.UserId==this.user.id){ // CHECKING USER checking each order that user have been already ordered
                        console.log("same user")
                        let state:boolean = true;
                        for(let i = 0 ;i<res.orderItems.length;i++){// +" ==="+this.order.id   +"
                        
                            console.log(i)
                            // console.log(res.orderItems[i].id   +"checking" +this.order.id )
                            if(res.orderItems[i].id ==this.order.id){ // CHECKING ORDER checking food item already present
                              
                              console.log("same food item   incrementing quantity"+ res.orderItems[i].quantity)
                              res.orderItems[i].quantity++
                              console.log(res.orderItems[i].quantity)
                              console.log(res.orderItems[i].price+this.order.price)
                              res.orderItems[i].price=res.orderItems[i].price+this.order.price
                              state = false
                              res.Total=res.Total+this.order.price
                              newOrder=false
                              console.log("new order STATUS=" + state)
                              this.restaurantService.placeOrder(res,res.id  ) 
                              break 
                            }
                        }
                        // console.log(state)

                      if(state){
                        let fooditem = new foodOrders();
                        this.order.quantity=1
                        this.order.totalPrice=this.order.price
                        fooditem = this.order
                        console.log("array added to main object STATUS="+state)
                        // fooditem.quantity = 
                        res.orderItems = [... res.orderItems,fooditem];  ///new fooditem is add to existing car
                        res.Total=res.Total+fooditem.price
                        newOrder=false
                        console.log("status new user" + newOrder)
                        this.restaurantService.placeOrder(res,res.id  )
                        break
                      }
                      // console.log(res) 
                      
                      

                    
              }
             
              }
              if(newOrder){   // placing new order  that user has not order anything before
                // console.log("resp is empty")
                console.log("new user ordering STATUS ="+newOrder )
                let foodOrder = new foodOrders()
                let custOrder = new customerOrder()
                custOrder.UserId = this.user.id
                custOrder.date= new Date()
                this.order.quantity=1
                this.order.totalPrice=this.order.price
                custOrder.UserId=this.user.id
                custOrder.orderItems.push(this.order )  
                custOrder.Total = this.order.price
                // console.log("calling place new order")
                this.restaurantService.placeNewOrder(custOrder)
              
              
                 }
            // ); //for each
          }

    }
  )

  this.routerService.cartPage();
}


//   addToCart() {
//     let localArray: Array<foodOrders> = [];
//     localArray = this.custOrder.orderItems;
//     console.log(this.order)
//     this.order.quantity = this.formValue.value.quantity;
//     this.order.totalPrice = this.formValue.value.quantity * this.order.price;
//     console.log(this.order.totalPrice)
//     this.totalPrice = this.totalPrice + this.order.totalPrice
//      localArray = [...localArray, this.order];
//     console.log("------from local array---", localArray);

//     //console.log(this.custOrder.orderItems)
//      this.custOrder.orderItems = localArray;
//     console.log(this.custOrder.orderItems)
// }

// orderArray(foodOrder: foodOrders) {

//     console.log(this.ordersArray)
//     console.log(foodOrder)
//     this.custOrder.orderItems = [...this.custOrder.orderItems, foodOrder]
//     console.log(this.ordersArray)

//     console.log("food item added to an array")
//   }


// placeOrder() {
//     let dat = new Date
//     let today1 = dat.getDate() + "-" + (dat.getMonth()) + "-" + dat.getFullYear()
//     console.log(today1)
//     console.log("hello order")
//     console.log()
//     this.custOrder.UserId = this.user.name
//     // this.custOrder.orderItems = this.ordersArray
//     this.custOrder.Total = this.totalPrice
//     console.log(this.totalPrice + "total price place order function")
//     console.log(this.ordersArray + "order array in  place order")

//     this.custOrder.date = today1

//     console.log(this.custOrder.date)
//     this.restaurantService.placeOrder(this.custOrder).subscribe(res => {

//       console.log(res);

//     })


//  }

  setUserName(userName: string) {
    this.user.name = userName

  }
  viewBill() {

    this.router.navigate(['generateBillPage'])
  }

  getUserName() {
    return this.user.name

  }
  cancelOrder() {

  }

  viewCart() {

  }
}
