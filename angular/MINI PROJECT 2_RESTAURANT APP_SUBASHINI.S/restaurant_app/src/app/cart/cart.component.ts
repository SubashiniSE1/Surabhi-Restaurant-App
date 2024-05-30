import { Component, OnInit } from '@angular/core';
import { customerOrder } from '../models/customer-order/customer-order.module';
import { foodOrders } from '../models/food-orders/food-orders.module';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { RouterServiceService } from '../services/router-service.service';
import { Menu } from '../models/food-items/food-items.module';
import { register } from '../models/register/register.module';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  user: register = new register()
  foodItems:Array<foodOrders> = [];
  cuss:Array<customerOrder>=[]
  

     foodorder : foodOrders = new foodOrders
     foodOr :Array<foodOrders>=[];

  constructor(private restaurantService: RestaurantServiceService,
    private routerService:RouterServiceService) {
      this.restaurantService.checkUser().subscribe(resp => {
        this.user.name = resp.name
        this.user.id=resp.customerId
        this.restaurantService.getFoodOrders().subscribe(resp=>{
          for(let i=0;resp.length;i++){
            if(resp[i].UserId==this.user.id){

                    resp.map(data => {
                    const res2= data.orderItems.map(fooditems=>{
                      console.log("mapped here")
                      console.log(fooditems)
                      return {
                        images: fooditems.images,
                        name: fooditems.name,
                        price: fooditems.totalPrice,  /// total price need to be an price  its an spelling mistake
                        quantity:fooditems.quantity,
                        itemstotalPrice:fooditems.price  // price is an total price of every individual element total quantity in cart 
                        
                      //   price :data.price,
                      //  quantity :  data.quantity
                    
                        
                      }

                    })
                    this.foodOr=[...data.orderItems]
                     
                    })

                }
            }
          
        //  this.= [...res];

      })
      })
     

      }
     

  ngOnInit(): void {
  }

}
