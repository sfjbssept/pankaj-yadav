import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = "http://localhost:8091/admin"

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  createAirline(airline : {airlineName:String, contactNumber:number, description:String}) {
    return this.http.post(BASE_URL+"/addAirLine", airline);
  }

  getAirlines() {
    return this.http.get(BASE_URL+"/getAirLines");
  }

  deleteAirline(airline:any) {
    return this.http.delete(BASE_URL + airline.id)
  }


  constructor(public http: HttpClient) { }
}
