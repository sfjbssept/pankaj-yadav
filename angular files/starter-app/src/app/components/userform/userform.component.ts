import { Component, OnInit } from '@angular/core';
import Student from 'src/app/entity/Student';
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  student:Student = new Student();

  save(){
    const observables = this.studentService.createStudent(this.student);
    observables.subscribe(
      (response : any)=>{
        console.log(response);
      },
      function (error){
        console.log(error);
        alert("Something went wrong try again");
      }
    )
  }
  // username:String = "";
  // age:number = 0;
  // title = 'Student Registration';
  // desc:String = "AngularJS extends HTML with new attributes,AngularJS is perfect for Single Page Applications (SPAs).AngularJS is easy to learn."

  // save(){
  //   console.log("the user's name is "+this.username+" whose age is: "+this.age);
  // }

  constructor(public studentService : StudentsService) { }

  ngOnInit(): void {
  }

}
