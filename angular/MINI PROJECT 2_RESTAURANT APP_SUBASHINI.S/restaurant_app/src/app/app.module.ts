import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RestaurantDashBoardComponent } from './restaurant-dash-board/restaurant-dash-board.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MenuCardComponent } from './menu-card/menu-card.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from '@angular/material/card';
import { UserMenuCardComponent } from './user-menu-card/user-menu-card.component';
import { GenerateBillComponent } from './generate-bill/generate-bill.component';
import { GenetareTodayBillComponent } from './genetare-today-bill/genetare-today-bill.component';
import { GenerateMonthlyBillComponent } from './generate-monthly-bill/generate-monthly-bill.component';
import { HeaderComponent } from './header/header.component';
import { ContentDashboardComponent } from './content-dashboard/content-dashboard.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantDashBoardComponent,
    LoginComponent,
    RegisterComponent,
    MenuCardComponent,
    UserMenuCardComponent,
    GenerateBillComponent,
    GenetareTodayBillComponent,
    GenerateMonthlyBillComponent,
    HeaderComponent,
    ContentDashboardComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    ReactiveFormsModule,
    HttpClientModule ,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
