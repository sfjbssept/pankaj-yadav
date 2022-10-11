import { Component, OnInit } from '@angular/core';
import Student from 'src/app/entity/Student';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  student:Student = new Student();
  // username:String = "";
  // age:number = 0;
  // title = 'Student Registration';
  // desc:String = "AngularJS extends HTML with new attributes,AngularJS is perfect for Single Page Applications (SPAs).AngularJS is easy to learn."

  // save(){
  //   console.log("the user's name is "+this.username+" whose age is: "+this.age);
  // }

  constructor() { }

  ngOnInit(): void {
  }

}
