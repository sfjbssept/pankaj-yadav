import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { RegisteredstudentComponent } from './components/registeredstudent/registeredstudent.component';

// const routes: Routes = [];
const routes: Routes = [{path:"home",component:HomeComponent},{path:"register",component:RegisterComponent},{path:"about",component:AboutComponent},{path:"contact",component:ContactComponent},
                        {path:"registeredStudents",component:RegisteredstudentComponent}];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
