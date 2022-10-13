import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Student from '../entity/Student';
const BASE_URL = "http://localhost:5000/students"

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  createStudent(student:{
    firstname : String;
    lastname : String;
    age : number;
    class : number;
    subject : String;
    gender : String;
  }){
    return this.http.post(BASE_URL, student);
  }

  getStudents(){
    return this.http.get(BASE_URL);
  }

  deleteStudents(student : any){
    return this.http.delete(BASE_URL+ student.id);
  }

  constructor(public http : HttpClient) { }
}
