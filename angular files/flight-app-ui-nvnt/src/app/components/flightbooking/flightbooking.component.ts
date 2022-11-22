import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
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
  flightForm = new FormGroup({
    seatCount:new FormControl(''),
    email:new FormControl(''),
    flightnumber:new FormControl(''),
    flightDetails: new FormArray([])
  })
  responseMessage: any;

  flightDetails(){
    return new FormGroup({
      firstName:new FormControl(''),
      lastName:new FormControl(''),
      gender:new FormControl('Male'),
      age:new FormControl('Male'),
      mealOpted:new FormControl('Male'),
      seatNumber:new FormControl('Male'),
      startDateTime:new FormControl('Male'),
      endDateTime:new FormControl('Male')
    })
  }

  skills() : FormArray {
    return this.flightForm.get("flightDetails") as FormArray
  }

  get newSkills() : FormArray {
    return this.flightForm.get("flightDetails") as FormArray
  }

  addSkills() {
    this.newSkills.push(this.flightDetails());
  }

  booking: Booking = new Booking();
  bookingDetail: FlightBookingDetail = new FlightBookingDetail();
  selectedFlight: String = "";
  flights : String[] = []; 
  user: any = sessionStorage.getItem("USER");
  name : String = "Pankaj";
  pnr: number = 0;


  save() {
    //this.parseSelectedFlight();
    const formData = {
      userName: sessionStorage.getItem('USER'),
      seatCount:this.flightForm.value.seatCount,
      email:this.flightForm.value.email,
      flightnumber:this.flightForm.value.flightnumber,
      flightDetails:this.flightForm.value.flightDetails
    }

    console.log(formData)
    const observables = this.flightService.bookFlight(formData);
    observables.subscribe(
      (response: any) => {
        this.responseMessage = response.responseMessage;
         console.log(response);
         alert(response.responseMessage)
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
    this.bookingDetail.user = "Pankaj";
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
    });
    this.flightForm.get('seatCount')?.valueChanges.subscribe((value)=>{
      if(value){
        (this.flightForm.get('flightDetails') as FormArray).clear();
        for (let index = 0; index < parseInt(value); index++) {
          this.addSkills();
        }
      }
      else{
        (this.flightForm.get('flightDetails') as FormArray).clear();
      }
      
      
    })
  }

  constructor(public flightService: FlightserviceService) {
    //this.addSkills();
  }

}
