import { Component, OnInit } from '@angular/core';
import Airline from 'src/app/entity/Airline';
import { AirlineService } from 'src/app/Services/airline.service';

@Component({
  selector: 'app-airline',
  templateUrl: './airline.component.html',
  styleUrls: ['./airline.component.css']
})
export class AirlineComponent implements OnInit {

  airline: Airline = new Airline();
  user: any = sessionStorage.getItem("USER");

  save() {
    const observables = this.airlineService.createAirline(this.airline)
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

  constructor(public airlineService: AirlineService) { }

  ngOnInit(): void {
  }

}
