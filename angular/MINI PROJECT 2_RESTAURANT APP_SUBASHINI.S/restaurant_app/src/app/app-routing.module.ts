import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RestaurantDashBoardComponent } from './restaurant-dash-board/restaurant-dash-board.component';
import { MenuCardComponent } from './menu-card/menu-card.component';
import { UserMenuCardComponent } from './user-menu-card/user-menu-card.component';
import { GenerateBillComponent } from './generate-bill/generate-bill.component';
import { GenetareTodayBillComponent } from './genetare-today-bill/genetare-today-bill.component';
import { GenerateMonthlyBillComponent } from './generate-monthly-bill/generate-monthly-bill.component';
import { HeaderComponent } from './header/header.component';
import { ContentDashboardComponent } from './content-dashboard/content-dashboard.component';
import { CartComponent } from './cart/cart.component';
import { CanActiveGuardGuard } from './guards/can-active-guard.guard';


const routes: Routes = [
  

  {
    path: '',
    component: ContentDashboardComponent,
    
  },
  {
    path: 'homePage',
    component: ContentDashboardComponent
  },
  {
    path: 'yourCart',
    component: CartComponent
  },
  {
    path: 'login',
    component: LoginComponent,
    
  },
  {
    path: 'register',
    component: RegisterComponent,
    
  },
  {
    path: 'RestaurantDashBoard',
    component: RestaurantDashBoardComponent,
    
  },
  {
    path: 'MenuCardpage',
    component: MenuCardComponent,
   
    
   
  },
  {
    path: 'viewMenuCardpage',
    component: UserMenuCardComponent,
    canActivate:[CanActiveGuardGuard]
   
    
  },
  {
    path: 'generateBillPage',
    component:  GenerateBillComponent,
    canActivate:[CanActiveGuardGuard]
    
  },
  {
    path: 'generatetodayBillPage',
    component:  GenetareTodayBillComponent,
   
    
  },
  {
    path: 'generateMonthlyBillPage',
    component:  GenerateMonthlyBillComponent,
    
  
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
