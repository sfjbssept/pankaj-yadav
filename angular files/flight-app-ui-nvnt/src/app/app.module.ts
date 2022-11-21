import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FlightadminComponent } from './components/flightadmin/flightadmin.component';
import { HttpClientModule } from '@angular/common/http';
import { AirlineComponent } from './components/airline/airline.component';
import { FlighcreateComponent } from './components/flighcreate/flighcreate.component';
import { FlightbookingComponent } from './components/flightbooking/flightbooking.component';
import { BookingMgtComponent } from './components/booking-mgt/booking-mgt.component';
import { LoginComponent } from './components/login/login.component';
import { SearchflightComponent } from './components/searchflight/searchflight.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FlightadminComponent,
    AirlineComponent,
    FlighcreateComponent,
    FlightbookingComponent,
    BookingMgtComponent,
    LoginComponent,
    SearchflightComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
