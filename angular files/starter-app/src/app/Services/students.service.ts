import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const BASE_URL = "http://localhost:5000/students"

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  createStudent(){}

  constructor() { }
}
