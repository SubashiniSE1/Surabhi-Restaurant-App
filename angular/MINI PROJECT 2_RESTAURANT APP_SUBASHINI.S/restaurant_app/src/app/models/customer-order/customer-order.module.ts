import { foodOrders } from "../food-orders/food-orders.module";

export class customerOrder{
  id: number=0;
  UserId:number=0;
  orderItems:Array<foodOrders>=[];
  Total:number=0;
  date: Date|any;
  split: any;
  }