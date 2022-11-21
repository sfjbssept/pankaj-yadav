import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlineComponent } from './components/airline/airline.component';
import { BookingMgtComponent } from './components/booking-mgt/booking-mgt.component';
import { FlighcreateComponent } from './components/flighcreate/flighcreate.component';
import { FlightadminComponent } from './components/flightadmin/flightadmin.component';
import { SearchflightComponent } from './components/searchflight/searchflight.component';
import { FlightbookingComponent } from './components/flightbooking/flightbooking.component';
import { LoginComponent } from './components/login/login.component';
import Airline from './entity/Airline';

const routes: Routes = [
{path:"airline", component:AirlineComponent},
{path:"flightcreate", component:FlighcreateComponent},
{path:"flightadmin", component:FlightadminComponent},
{path:"searchflight", component:SearchflightComponent},
{path:"flightbooking", component:FlightbookingComponent},
{path:"login", component:LoginComponent},
{path:"bookingMgt", component:BookingMgtComponent},
{path:"", component:LoginComponent},
{path:"logout", component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
