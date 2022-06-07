import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {PatientService} from "../../services/patient.service";
import {MatDialog} from "@angular/material/dialog";
import {AddPatientComponent} from "../patient/add-patient/add-patient.component";
import {EditPatientComponent} from "../patient/edit-patient/edit-patient.component";
import {TestresultOverviewComponent} from "../testresult/testresult-overview/testresult-overview.component";
import {LabValue} from "../../dtos/labValue";
import {LabValService} from "../../services/lab-val.service";
import {AddLabValueComponent} from "./add-lab-value/add-lab-value.component";

@Component({
  selector: 'app-lab-value',
  templateUrl: './lab-value.component.html',
  styleUrls: ['./lab-value.component.scss']
})
export class LabValueComponent implements OnInit {

  error = false;
  errorMessage = '';
  // @ts-ignore
  labValues: LabValue[];

  displayedColumns: string[] = ['name', 'unit', 'category'];

  constructor(
    private labValueService: LabValService,
    private readonly dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.loadAllLabValues();
  }

  addLabValue(){
    const dialog = this.dialog.open(AddLabValueComponent, {width: '500px'});
    dialog.afterClosed().subscribe(() => {
      this.loadAllLabValues();
    })
  }

  /**
   * Fetches all labValues from the backend.
   */
  public loadAllLabValues() {
    this.labValueService.getAllLabVals().subscribe({
      next: data => {
        console.log('received patients', data);
        this.labValues = data;

        console.log(this.labValues);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  deletePatient(labValue: LabValue) {
    if (confirm('LabValue "' + labValue.labValName + '" wirklich löschen?')) {
      this.labValueService.deleteLabValue(labValue.labValId).subscribe({
        next: () => {
          console.log("Deleting labValue " + labValue)
          this.loadAllLabValues();
        }
        ,
        error: error => {
          this.defaultServiceErrorHandling(error);
        }
      });
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
