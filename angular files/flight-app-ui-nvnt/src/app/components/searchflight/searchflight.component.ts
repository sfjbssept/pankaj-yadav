import { Component, OnInit } from '@angular/core';
import { SearchflightService } from 'src/app/Services/searchflight.service';
import { FlightserviceService } from 'src/app/Services/flightservice.service';
import Flight from 'src/app/entity/Flight';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-searchflight',
  templateUrl: './searchflight.component.html',
  styleUrls: ['./searchflight.component.css']
})
export class SearchflightComponent implements OnInit {
  searchForm = new FormGroup({
    searchType:new FormControl('flightNumber'),
    searchText:new FormControl(''),
    source:new FormControl(''),
    destination:new FormControl(''),
  })
  //define speciesname for component
  speciesName: string = "";
  flights: Flight[] = [];
  user: any = sessionStorage.getItem("USER");
  flightResults: any;

  // getSearchResult() {
  //   this.searchflightService.getFlightByNumber(this.speciesName).subscribe(result => {
  //     this.speciesList = result.results;
  //   }, error => this.toastr.error(error.statusText, '', {
  //     timeOut: 3000
  //   }));
  // }

  deleteFlight1(flight: any,index: number) {
    const observable = this.searchflightService.getFlightByNumber(flight);
    observable.subscribe((response:any) => {
      console.log(response);
      this.flights.splice(index, 1)
    })
  }

  searchflightnumber() {
    //alert(this.searchForm.get('searrchText')?.value);
    const observable = this.searchflightService.getFlightByNumber(this.searchForm.get('searchText')?.value).subscribe((data)=>{
      console.log(data)
      this.flightResults = [data];
    })
  }

  searchByCity(){
    const observable = this.searchflightService.getFlightByCity(this.searchForm.get('source')?.value, this.searchForm.get('destination')?.value).subscribe((data)=>{
      console.log(data)
      this.flightResults = data;
    })
    
  }


  ngOnInit(): void {
    this.searchForm.get('searchType')?.valueChanges.subscribe((value)=>{
      this.flightResults = [];
    })
  }

  constructor(public searchflightService: FlightserviceService) { }
}
