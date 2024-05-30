import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from 'rxjs/operators';
import { register } from '../models/register/register.module';
import { Observable } from 'rxjs';
import { Menu } from '../models/food-items/food-items.module';
import { customerOrder } from '../models/customer-order/customer-order.module';
import { FormBuilder,FormGroup } from '@angular/forms';
import { currentUser } from '../models/currentuser/currentuser.module';



@Injectable({
  providedIn: 'root'
})
export class RestaurantServiceService {
  formValue !: FormGroup

  cusOrders:Array<customerOrder> = [];
  custOrder : customerOrder = new customerOrder();
  baseApiUrl="http://localhost:3000/Menu"
  
 

 
  constructor(private _http:HttpClient,private formBuilder: FormBuilder) {
  
  
   }


  // -------------------------- This is for User CRUD operations----------------------------------------------
  //now delete,put ,post,get 
  //create user using post method 
  postRestaurant(data:any){
    return this._http.post<any>("http://localhost:3000/register",data).pipe(map((res:any)=>{
      return res;
    
     

    }))
  }
  //get restaurant data usig get method
  getRestaurant(){
    return this._http.get<any>("http://localhost:3000/register").pipe(map((res:any)=>{
      return res;
  }))
  }

  storeName(name:string){
    localStorage.setItem("userName",name);
  }
  getName():string|null{
    return localStorage.getItem('userName');
  }
  
  updateRestaurant(data:any,id:number){
    return this._http.put<any>("http://localhost:3000/register/"+id,data).pipe(map((res:any)=>{
      return res;
  }))
}
//delete 
deleteRestaurant(id:number){
  //console.log(id)
  return this._http.delete<any>("http://localhost:3000/register/"+id).pipe(map((res:any)=>{
    return res;
}))
}



getLogin():Observable<Array<register>>{
 console.log( this._http.get<Array<register>>('http://localhost:3000/register'))
  return this._http.get<Array<register>>('http://localhost:3000/register')
}
getFoodItems():Observable<Array<Menu>>{
  return this._http.get<Array<Menu>>('http://localhost:3000/Menu')
}

addFoodItems(data:any){
  return this._http.post<any>("http://localhost:3000/Menu",data).pipe(map((res:any)=>{
    return res;

  }))
}

getOrderById(userId:number):Observable<Array<customerOrder>>{ 
  return this._http.get<Array<customerOrder>>(`http://localhost:3000/foodOrders/`)

}

getFoodItem(){
  return this._http.get<any>("http://localhost:3000/Menu").pipe(map((res:any)=>{
    return res;
}))
}

deleteFoodItem(id:number){
  //console.log(id)
  return this._http.delete<any>("http://localhost:3000/Menu/"+id).pipe(map((res:any)=>{
    return res;
}))
}

updateItems(data:any,id:number){
  console.log(id)
  return this._http.put<any>("http://localhost:3000/Menu/"+id,data).pipe(map((res:any)=>{
    return res;
}))
}
placeOrder(data:customerOrder , UserId:number){
  this.custOrder=data
  console.log("putting")
  // console.log(this.custOrder) 
  // console.log("in place order")
  
  return this._http.put<customerOrder>(`http://localhost:3000/foodOrders/${UserId}`,data).subscribe(data =>{
   
  })   //done aa
  // }))
  
}
placeNewOrder(order:customerOrder){
  // console.log(order)
  console.log("posting")
  return this._http.post<customerOrder>("http://localhost:3000/foodOrders",order).subscribe(data =>{
return data;});
  //  return res;
 // }))
}

getFoodOrders():Observable<Array<customerOrder>>{
  return this._http.get<customerOrder>("http://localhost:3000/foodOrders").pipe(map((res:any)=>{
    return res;
}))
}

getBills():Observable<Array<customerOrder>>{
 
  return this._http.get<Array<customerOrder>>('http://localhost:3000/foodOrders')
}

checkUser():Observable<currentUser>{
  return this._http.get<currentUser>('http://localhost:3000/currentUser/1')
}

setCuserName(user:currentUser):Observable<currentUser>{
  return this._http.put<currentUser>('http://localhost:3000/currentUser/1',user)
}

deleteCuser(id:number,user:currentUser):Observable<currentUser>{
 
  return this._http.put<currentUser>('http://localhost:3000/currentUser/1',user)
}


}


