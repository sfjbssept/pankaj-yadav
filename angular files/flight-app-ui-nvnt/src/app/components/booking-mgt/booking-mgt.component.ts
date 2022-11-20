import { Component, OnInit } from '@angular/core';
import FlightBookingDetail from 'src/app/entity/FlightBookingDetail';
import { FlightserviceService } from 'src/app/Services/flightservice.service';

@Component({
  selector: 'app-booking-mgt',
  templateUrl: './booking-mgt.component.html',
  styleUrls: ['./booking-mgt.component.css']
})
export class BookingMgtComponent implements OnInit {

  bookings: FlightBookingDetail[] = [];
  user: any = sessionStorage.getItem("USER");

  deleteBooking(booking: any,index: number) {
     const observable = this.flightService.deleteBooking(booking)
     observable.subscribe((response:any) => {
       console.log(response);
       this.bookings.splice(index, 1)
     })
  }

  constructor(public flightService: FlightserviceService) { }

  ngOnInit(): void {

    const promise = this.flightService.getBookings();
     promise.subscribe((response) => {
       console.log(response);
       this.bookings = response as FlightBookingDetail[];
     })

  }

}
