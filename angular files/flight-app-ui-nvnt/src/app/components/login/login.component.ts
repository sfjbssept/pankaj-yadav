import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";
  validUsers : String[] = [];

  login() {
    if (this.username == "admin") {
      sessionStorage.setItem("USER", "admin");
      this.router.navigate(['airline'])
    } else {
      sessionStorage.setItem("USER", this.username);
      this.router.navigate(['/searchflight'])
    }
    
  }

  public validate() : Boolean {
    return true;
  }

  constructor(private router: Router) { 
    this.validUsers[0] = "user"+"password";
    this.validUsers[1] = "admin"+"password";

  }

  ngOnInit(): void {
  }

}
