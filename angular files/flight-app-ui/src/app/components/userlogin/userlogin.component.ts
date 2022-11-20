import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  username: string = "";
  password: string = "";
  validUsers : String[] = [];

  login() {
    if (this.username == "user") {
      console.log("enter into user")
      sessionStorage.setItem("USER", "user");
      this.router.navigate(['airline'])
    }    
  }
  
  public validate() : Boolean {
    return true;
  }

  constructor(private router: Router) { 
    this.validUsers[0] = "user"+"password";
    this.validUsers[1] = "admin"+"password";

  }
  // constructor() { }

  ngOnInit(): void {
  }

}