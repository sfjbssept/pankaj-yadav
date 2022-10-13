import { Component, OnInit } from '@angular/core';
import Student from "src/app/entity/Student";
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-registeredstudent',
  templateUrl: './registeredstudent.component.html',
  styleUrls: ['./registeredstudent.component.css']
})
export class RegisteredstudentComponent implements OnInit {

  students : Student[] = [];

  deleteStudent(student, index){
    const observable = this.studentService.deleteStudents(student);
    observable.subscribe((response : any) => {
      console.log(response);
      this.students.splice(index,1);
    });
  }

  constructor(private studentService : StudentsService) { }

  ngOnInit(): void {
    // const promise = this.studentService.getStudents();
    // promise.subscribe((response) => {
      // console.log(response);
      // this.students = response as Student[];
    // });
  }

}
