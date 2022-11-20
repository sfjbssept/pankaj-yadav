import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  username: string = "";
  password: string = "";
  validUsers : String[] = [];

  login() {
    if (this.username == "admin") {
      console.log("enter into admin")
      sessionStorage.setItem("USER", "admin");
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
