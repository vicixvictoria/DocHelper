import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {PatientService} from "../../services/patient.service";
import {MatDialog} from "@angular/material/dialog";
import {AddPatientComponent} from "./add-patient/add-patient.component";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})



export class PatientComponent implements OnInit {

  error = false;
  errorMessage = '';
  patients: Patient[] | undefined;

  displayedColumns: string[] = ['name', 'address', 'svnr', 'birthday'];



  constructor(
    private patientService: PatientService,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.loadAllPatients();
  }

  addPatient(){
    this.dialog.open(AddPatientComponent, {width: '500px'});
  }

  /**
   * Fetches all patients from the backend.
   */
  private loadAllPatients() {
    this.patientService.getAllPatients().subscribe({
      next: data => {
        console.log('received patients', data);
        this.patients = data;
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
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
