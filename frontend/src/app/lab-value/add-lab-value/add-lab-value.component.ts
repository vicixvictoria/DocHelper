import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Patient} from "../../../dtos/patient";
import {PatientService} from "../../../services/patient.service";
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material/dialog";
import {LabValue} from "../../../dtos/labValue";
import {LabValService} from "../../../services/lab-val.service";



@Component({
  selector: 'app-add-lab-value',
  templateUrl: './add-lab-value.component.html',
  styleUrls: ['./add-lab-value.component.scss']
})
export class AddLabValueComponent implements OnInit {

  error = false;
  errorMessage = '';

  labValueForm: FormGroup;
  labValue: LabValue | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private labValueService: LabValService,
    private router: Router,
    private dialogRef: MatDialogRef<AddLabValueComponent>
  ) {
    // @ts-ignore
    this.labValue = new LabValue();

    this.labValueForm  = this.formBuilder.group({
      labValName: new FormControl(this.labValue.labValName, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      unit: new FormControl(this.labValue.unit, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      category: new FormControl(this.labValue.category, [])
    });
  }

  ngOnInit(): void {

  }

  addLabValue(): void {
    console.log("add labValue")
    if (this.labValueForm.valid) {
      // @ts-ignore
      this.labValue?.labValName = this.labValueForm.get('labValName')?.value;
      // @ts-ignore
      this.labValue?.unit = this.labValueForm.get('unit')?.value;
      // @ts-ignore
      this.labValue?.category = this.labValueForm.get('category')?.value;
      console.log(this.labValue);
      if (this.labValue) {
        this.labValueService.createLabValue(this.labValue).subscribe({
          next: result => {
            this.dialogRef.close();

          },
          error: error => {
            this.defaultServiceErrorHandling(error);
          }
        });
      }
    }
  }


  private defaultServiceErrorHandling(error: any) {
    console.log(error);
    this.error = true;
    if (error.status === 0) {
      // If status is 0, the backend is probably down
      this.errorMessage = 'The backend seems not to be reachable';
    } else if (error.error.message === 'No message available') {
      // If no detailed error message is provided, fall back to the simple error name
      this.errorMessage = error.error.error;
    } else {
      this.errorMessage = error.error.message;
    }
  }

}
