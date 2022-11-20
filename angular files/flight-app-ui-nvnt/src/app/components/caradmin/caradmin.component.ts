import { Component, OnInit } from '@angular/core';
import Car from 'src/app/entity/Car';
import { CarserviceService } from 'src/app/Services/carservice.service';

@Component({
  selector: 'app-caradmin',
  templateUrl: './caradmin.component.html',
  styleUrls: ['./caradmin.component.css']
})
export class CaradminComponent implements OnInit {

  public car:Car = new Car();

  save() {
    const observables = this.carservice.createCar(this.car)
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

  constructor(public carservice: CarserviceService) { }

  ngOnInit(): void {
  }

}
