import { Component, OnInit } from '@angular/core';
import Airline from 'src/app/entity/Airline';
import Flight from 'src/app/entity/Flight';
import { AirlineService } from 'src/app/Services/airline.service';
import { FlightserviceService } from 'src/app/Services/flightservice.service';

@Component({
  selector: 'app-flighcreate',
  templateUrl: './flighcreate.component.html',
  styleUrls: ['./flighcreate.component.css']
})
export class FlighcreateComponent implements OnInit {

  flight : Flight = new Flight();
  name : String = "Pankaj";
  airLines: Airline[] = []; 
  user: any = sessionStorage.getItem("USER");


  save() {
    const observables = this.flightService.createFlight(this.flight);
    observables.subscribe(
      (response: any) => {
        console.log(response);
      },
      function (error) {
        console.log(error);
        alert('Something went wrong try again!');
      }
    );
  }


  constructor(public flightService: FlightserviceService, public airLineService: AirlineService) {}

  ngOnInit(): void {
    const promise = this.airLineService.getAirlines();
    promise.subscribe((response) => {
    console.log(response);
    this.airLines = response as Airline[];
    }
  )}
}
