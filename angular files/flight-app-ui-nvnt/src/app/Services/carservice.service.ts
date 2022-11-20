import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = "http://localhost:7081/admin/"

@Injectable({
  providedIn: 'root'
})
export class CarserviceService {

  createCar(car : {make:String, model:String, version:String, doors:number, grossprice:number, netprice:number}) {
    return this.http.post(BASE_URL+"addCar", car);
  }

  getCars() {
    return this.http.get(BASE_URL+"getCars");
  }

  deleteAirline(car:any) {
    return this.http.delete(BASE_URL + car.id)
  }


  constructor(public http:HttpClient) { }
}
