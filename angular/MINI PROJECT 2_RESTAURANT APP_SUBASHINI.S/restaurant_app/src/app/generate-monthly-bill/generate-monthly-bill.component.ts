import { Component, OnInit } from '@angular/core';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { customerOrder } from '../models/customer-order/customer-order.module';

@Component({
  selector: 'app-generate-monthly-bill',
  templateUrl: './generate-monthly-bill.component.html',
  styleUrls: ['./generate-monthly-bill.component.css']
})
export class GenerateMonthlyBillComponent implements OnInit {

  bills: Array<customerOrder> = [];

  constructor(private restaurantService: RestaurantServiceService) {
    this.restaurantService.getBills().subscribe(res => {

      const res1 = res.map(data => {
        let dat = new Date
        let currentDate = dat.getDate()
        let currentMonth = dat.getMonth() + 1
        let currentYear = dat.getFullYear()
      //  let todayDate =dat.getDate
        let dateData = data.date.split("-", 3)
        
        if (currentYear.toString() === dateData[2]) {
          if (currentMonth.toString() === dateData[1]) {
            console.log("inside 2 if")
            return {

              id: data.id,
              username: data.UserId,
              orderdate: data.date,
              totalprice: data.Total
            }
          } else {
            console.log("else1")
            //this return for dummy
            return null
          }
        } else {
          console.log("else2")
          return null
        }
        // if(data.date ===today1){



        // map to front end
        //  res[i].id  ==> to order id 
        //  res[i].date  ==> ordered Date
        //  res[i].UserId   = >map to Username
        //  res[i].Total  = > map to total price 


        // the above all detail are mapped to bill generation table



      })

      this.bills = [...res];

    }
    )

  }

  ngOnInit(): void {
  }

}
