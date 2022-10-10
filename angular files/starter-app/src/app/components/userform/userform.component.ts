import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  username:String = "";
  age:number = 0;
  title = 'Hello-world';
  desc:String = "AngularJS extends HTML with new attributes,AngularJS is perfect for Single Page Applications (SPAs).AngularJS is easy to learn."

  save(){
    console.log("the user's name is "+this.username+" whose age is: "+this.age);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
