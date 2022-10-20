import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {
  formGroup: FormGroup;
  constructor(private fb: FormBuilder, public dialogRef: MatDialogRef<AdminloginComponent>, private service: ServiceService) {
    const formItem = {
      username: '',
      password: ''
    }
    this.formGroup = this.fb.group(formItem);
  }

  close() {
    this.dialogRef?.close();
  }

  logMeIn() {
    const formValue = this.formGroup.getRawValue();
    this.service.login(formValue).subscribe((data) => {
      console.log(data);
      this.dialogRef.close('loginSuccess');
    })
  }
}
