import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {PatientService} from "../../services/patient.service";
import {MatDialog} from "@angular/material/dialog";
import {AddPatientComponent} from "./add-patient/add-patient.component";
import {EditPatientComponent} from "./edit-patient/edit-patient.component";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})



export class PatientComponent implements OnInit {

  error = false;
  errorMessage = '';
  // @ts-ignore
  patients: Patient[];

  displayedColumns: string[] = ['name', 'address', 'svnr', 'birthday', 'gender', 'pregnant', 'aktion'];

  constructor(
    private patientService: PatientService,
    private readonly dialog: MatDialog,

  ) {
  }

  ngOnInit(): void {
    this.loadAllPatients();
  }

  addPatient(){
    const dialog = this.dialog.open(AddPatientComponent, {width: '500px'});
    dialog.afterClosed().subscribe(() => {
      this.loadAllPatients();
    })
  }

  editPatient(patient: Patient){
    this.dialog.open(EditPatientComponent, {
      data: {
        patient: patient
      },
      width: '500px'});
  }

  /**
   * Fetches all patients from the backend.
   */
  public loadAllPatients() {
    this.patientService.getAllPatients().subscribe({
      next: data => {
        console.log('received patients', data);
        this.patients = data;
        console.log(this.patients);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  /**
   * Deletes horse from the backend.
   *
   * @param patient to be deleted.
   */
  deletePatient(patient: Patient) {
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
