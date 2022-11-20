import { Component, OnInit } from '@angular/core';
import Booking from 'src/app/entity/Booking';
import Flight from 'src/app/entity/Flight';
import FlightBookingDetail from 'src/app/entity/FlightBookingDetail';
import { FlightserviceService } from 'src/app/Services/flightservice.service';


@Component({
  selector: 'app-flightbooking',
  templateUrl: './flightbooking.component.html',
  styleUrls: ['./flightbooking.component.css']
})

export class FlightbookingComponent implements OnInit {

  booking: Booking = new Booking();
  bookingDetail: FlightBookingDetail = new FlightBookingDetail();
  selectedFlight: String = "";
  flights : String[] = []; 
  user: any = sessionStorage.getItem("USER");
  name : String = "Sanjay";
  pnr: number = 0;


  save() {
    this.parseSelectedFlight();
    const observables = this.flightService.bookFlight(this.bookingDetail);
    observables.subscribe(
      (response: any) => {
         console.log(response);
      },
      function (error) {
         console.log(error);
         alert('Something went wrong try again!');
      }
    );
    this.generatePNR();
  }

  parseSelectedFlight() {
    const array = this.booking.flight.split(":");
    this.bookingDetail.user = "Sanjay";
    this.bookingDetail.airline = array[0];
    this.bookingDetail.source = array[1];
    this.bookingDetail.destination = array[2];
    this.bookingDetail.date = array[3];
    this.bookingDetail.fare = parseInt(array[4]);
    this.bookingDetail.seatcount = this.booking.seats;
  }

  generatePNR() {
    var d = new Date(); // for now
    d.getHours(); // => 9
    d.getMinutes(); // =>  30
    d.getSeconds(); // => 51
    var time = d.getUTCMilliseconds;
    this.pnr = Math.floor((Math.random() * 10000000) + 1);//time.toString; //d.getDay+d.getHours+d.getMinutes+d.getSeconds;
  }

  allFlights() {
    
  }

  deleteBooking(booking: any,index: number) {
   
  }

  ngOnInit(): void {
    //const promise = this.flightService.getFlight(); //getFlightsAsStringList()
    const promise = this.flightService.getFlightsAsStringList()
    promise.subscribe((response) => {
      console.log(response);
      //this.flights = response as Flight[]; //String[];
      this.flights = response as String[];
    })
  }

  constructor(public flightService: FlightserviceService) {}

}
