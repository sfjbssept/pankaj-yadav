import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = "http://localhost:8084/flight"

const BASE_URL_USER = "http://localhost:8092/user"

@Injectable({
  providedIn: 'root'
})
export class FlightserviceService {

  createFlight(flight : {flightNumber:number, airline:String, flightSource:String, flightDestination:String, startDateTime:String, endDateTime:String, scheduledDays:String, instruments:String, businessClassSeat:Number, nonBusinessClassSeat:Number, ticketFare:Number, flightRows:Number, mealType:String}) {
    return this.http.post(BASE_URL+"/register", flight);
  }

  getFlight() {
    return this.http.get(BASE_URL);
  }

  deleteFlight(flight:any) {
    return this.http.delete(BASE_URL+"/" + flight.flightNumber)
  }

  getFlightsAsStringList() {
    //return this.http.get(BASE_URL_USER+"/flights");
    return this.http.get(BASE_URL+"/getFlightStrArray");
  }

  getFlightByNumber(flightNumber:any) {
    //return this.http.get(BASE_URL_USER+"/flights");
    return this.http.get(BASE_URL+"/"+ flightNumber);
  }

  searchTktByPNR(pnrnumber:any){
    return this.http.get(BASE_URL+"/ticket/"+ pnrnumber);
  }

  getFlightByCity(source:any,destination:any) {
    //return this.http.get(BASE_URL_USER+"/flights");
    return this.http.get(BASE_URL+"/locations?source="+source+"&destination="+destination);
  }

  //=======================Flight Booking MGT================================
  bookFlight(formData:any) {
    return this.http.post(BASE_URL+"/book/"+formData.flightnumber+"?userName="+formData.userName+"&seatCount="+formData.seatCount+"&email="+formData.email, formData.flightDetails);
  }

  getBookings() {
    return this.http.get(BASE_URL+"/getBookings")
  }

  deleteBooking(booking: any) {
    return this.http.delete(BASE_URL+"/ticket/"+booking)
  }

  constructor(public http: HttpClient) { }
}



