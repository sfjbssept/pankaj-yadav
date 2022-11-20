import { Component, OnInit } from '@angular/core';
import Airline from 'src/app/entity/Airline';
import Flight from 'src/app/entity/Flight';
import { AirlineService } from 'src/app/Services/airline.service';
import { FlightserviceService } from 'src/app/Services/flightservice.service';

@Component({
  selector: 'app-flightadmin',
  templateUrl: './flightadmin.component.html',
  styleUrls: ['./flightadmin.component.css']
})

export class FlightadminComponent implements OnInit {

  airline: Airline = new Airline();
  flights: Flight[] = [];
  user: any = sessionStorage.getItem("USER");

  deleteFlight1(flight: any,index: number) {
    const observable = this.flighService.deleteFlight(flight);
    observable.subscribe((response:any) => {
      console.log(response);
      this.flights.splice(index, 1)
    })
  }
  


  constructor(public flighService: FlightserviceService) { }

  ngOnInit(): void {

    const promise = this.flighService.getFlight();
     promise.subscribe((response) => {
       console.log(response);
       this.flights = response as Flight[];
     })

  }

}



