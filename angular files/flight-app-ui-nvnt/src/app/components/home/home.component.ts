import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AdminloginComponent } from '../adminlogin/adminlogin.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  ShowSignInBtn = true;
  constructor(public dialog: MatDialog) {}
  openLoginPopup() {
    const dialogRef = this.dialog.open(AdminloginComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ShowSignInBtn = false;
      }
      console.log(`Dialog result: ${result}`);
    });
  }
}
