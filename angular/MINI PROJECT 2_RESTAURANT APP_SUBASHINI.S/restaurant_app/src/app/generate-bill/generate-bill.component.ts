import { Component, OnInit } from '@angular/core';
import { customerOrder } from '../models/customer-order/customer-order.module';
import { FormGroup } from '@angular/forms';
import { RestaurantServiceService } from '../services/restaurant-service.service';

@Component({
  selector: 'app-generate-bill',
  templateUrl: './generate-bill.component.html',
  styleUrls: ['./generate-bill.component.css']
})
export class GenerateBillComponent implements OnInit {
  cusorder: customerOrder = new customerOrder;
  formValue !: FormGroup
  formBuilder: any;
  custOrders: Array<customerOrder> = [];
  user: any;

  constructor(private restaurantService: RestaurantServiceService) {
    let c = 0
    this.restaurantService.checkUser().subscribe(resp => {
      console.log(resp.customerId)
      console.log(resp.name)
      this.user = resp.name
    })
    let todayDate = new Date
    console.log(todayDate)

    this.restaurantService.getBills().subscribe(res => {

      const res1 = res.map(data => {
        let dat = new Date
        let today1 = dat.getDate() + "-" + dat.getMonth() + "-" + dat.getFullYear()
        console.log(today1)
        console.log("before if")
        if (data.date === dat) {
          if (data.UserId === this.user) {
            console.log(c)
            c++
            console.log("after if")
            console.log(data)
            let res2 = {
              id: data.id,
              username: data.UserId,
              orderdate: data.date,
              totalprice: data.Total,

            }
            return res2
          }
          else
            return 0
        } else return 0
      })

      this.custOrders = [...res];
    })

  }
  ngOnInit(): void {

  }
}
