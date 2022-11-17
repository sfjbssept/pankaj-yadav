import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 constructor(){

 }

  username:String = "";
  age:number = 0;
  title = 'Hello-world';
  desc:String = "AngularJS extends HTML with new attributes,AngularJS is perfect for Single Page Applications (SPAs).AngularJS is easy to learn."

  save(){
    console.log("the user's name is "+this.username+" whose age is: "+this.age);
  }
}
