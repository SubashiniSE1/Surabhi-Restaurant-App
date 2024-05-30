import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { customerOrder } from '../models/customer-order/customer-order.module';
import { RestaurantServiceService } from '../services/restaurant-service.service';
import { UserMenuCardComponent } from '../user-menu-card/user-menu-card.component';

@Component({
  selector: 'app-genetare-today-bill',
  templateUrl: './genetare-today-bill.component.html',
  styleUrls: ['./genetare-today-bill.component.css']
})
export class GenetareTodayBillComponent implements OnInit {
  res: Array<customerOrder> = []
  formValue !: FormGroup
  formBuilder: any;
  bills: Array<customerOrder> = [];
  constructor(private restaurantService: RestaurantServiceService) {

    this.restaurantService.getBills().subscribe(res => {

      const res1 = res.map(data => {
        let dat = new Date
        let today1 = dat.getDate() + "-" + dat.getMonth() + "-" + dat.getFullYear()
        console.log(today1)
        if (data.date === dat) {
          return {
            id: data.id,
            username: data.UserId,
            orderdate: data.date,
            totalprice: data.Total
          }
        } else {

          //this return for dummy
          return null
        }

        // map to front end
        //  res[i].id  ==> to order id 
        //  res[i].date  ==> ordered Date
        //  res[i].UserId   = >map to Username
        //  res[i].Total  = > map to total price 


        // the above all detail are mapped to bill generation table
        //foodname table la venam athu pota table perusa irukum nla irukathu verum order id , username , date , total price matum pothum


      })
      // this.foodItems = [...res];
      this.bills = [...res];

    }
    )

  }

  ngOnInit(): void {

  }
}
