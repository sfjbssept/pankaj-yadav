import { Component, OnInit } from '@angular/core';
import FlightBookingDetail from 'src/app/entity/FlightBookingDetail';
import { FlightserviceService } from 'src/app/Services/flightservice.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-booking-mgt',
  templateUrl: './booking-mgt.component.html',
  styleUrls: ['./booking-mgt.component.css']
})
export class BookingMgtComponent implements OnInit {
  searchForm = new FormGroup({
    searchType:new FormControl('flightNumber'),
    searchText:new FormControl(''),
    source:new FormControl(''),
    destination:new FormControl(''),
  })

  bookings: FlightBookingDetail[] = [];
  user: any = sessionStorage.getItem("USER");
  tktResults: any;

  deleteBooking(booking: any,index: number) {
     const observable = this.flightService.deleteBooking(booking)
     observable.subscribe((response:any) => {
       console.log(response);
       this.bookings.splice(index, 1)
     })
  }

  // (){
  //   const observable = this.flightService.searchTktByPNR(booking)
  //   alert("we are in search PNR");
  // }

  searchPNRdetail() {
    alert(this.searchForm.get('searchText')?.value);
    const observable = this.flightService.searchTktByPNR(this.searchForm.get('searchText')?.value).subscribe((data)=>{
      console.log(data)
      this.tktResults = [data];
    })
  }

  constructor(public flightService: FlightserviceService) { }

  ngOnInit(): void {
    this.tktResults = [];
    const promise = this.flightService.getBookings();
     promise.subscribe((response) => {
       console.log(response);
       this.bookings = response as FlightBookingDetail[];
     })

  }

}
