import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';

const routes: Routes = [{path:"login",component:AdminloginComponent}];

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
