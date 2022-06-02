import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {PatientService} from "../../services/patient.service";
import {MatDialog} from "@angular/material/dialog";
import {AddPatientComponent} from "../patient/add-patient/add-patient.component";
import {EditPatientComponent} from "../patient/edit-patient/edit-patient.component";
import {TestresultOverviewComponent} from "../testresult/testresult-overview/testresult-overview.component";
import {LabValue} from "../../dtos/labValue";
import {LabValService} from "../../services/lab-val.service";

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

  displayedColumns: string[] = ['name', 'address', 'svnr', 'birthday', 'gender', 'pregnant', 'aktion'];

  constructor(
    private labValueService: LabValService,
    private readonly dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.loadAllLabValues();
  }

  addLabValue(){
    const dialog = this.dialog.open(AddPatientComponent, {width: '500px'});
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
/*
  /**
   * Deletes horse from the backend.
   *
   * @param patient to be deleted.
   */
  /*deletePatient(patient: Patient) {
    if (confirm('Patient "' + patient.firstName + ' ' + patient.lastName + '" wirklich löschen?')) {
      this.patientService.deletePatient(patient.id).subscribe({
        next: () => {
          console.log("Deleting Patient " + patient)
          this.loadAllPatients();
        }
        ,
        error: error => {
          this.defaultServiceErrorHandling(error);
        }
      });
    }
  }*/

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
