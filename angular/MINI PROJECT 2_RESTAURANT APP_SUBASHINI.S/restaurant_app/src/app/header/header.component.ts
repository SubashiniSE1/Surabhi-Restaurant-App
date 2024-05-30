import { Component, OnInit } from '@angular/core';
import { RouterServiceService } from '../services/router-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title = "SURABI RESTAURANT";

  constructor(private routerService: RouterServiceService) { }

  ngOnInit(): void {
  }


  userLogin() {
    this.routerService.homeLogin()

  }

  userSignUp() {
    this.routerService.homeSignUp();

  }

}
