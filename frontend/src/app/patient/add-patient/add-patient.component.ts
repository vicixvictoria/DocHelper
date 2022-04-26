import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Patient} from "../../../dtos/patient";
import {PatientService} from "../../../services/patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
})
export class AddPatientComponent implements OnInit {
  error = false;
  errorMessage = '';

  patientForm: FormGroup;
  patient: Patient | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private patientService: PatientService,
    private router: Router
  ) {
    // @ts-ignore
    this.patient = new Patient();
    this.patient.pregnant = false;

    this.patientForm  = this.formBuilder.group({
      firstname: new FormControl(this.patient.firstName, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      lastname: new FormControl(this.patient.lastName, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      svnr: new FormControl(this.patient.svnr, [
        Validators.required,  Validators.pattern('[0-9]*'), Validators.minLength(10), Validators.maxLength(10)]),
      pregnant: new FormControl(this.patient.pregnant, []),
      birthday: new FormControl(this.patient.birthDate, [
        Validators.required]),
      gender: new FormControl(this.patient.sex, [
        Validators.required])
    });
  }

  ngOnInit(): void {

  }

  addPatient(): void {
    console.log("add patient")
    if (this.patientForm.valid) {
      // @ts-ignore
      this.patient?.firstName = this.patientForm.get('firstname')?.value;
      // @ts-ignore
      this.patient?.lastName = this.patientForm.get('lastname')?.value;
      // @ts-ignore
      this.patient?.svnr = this.patientForm.get('svnr')?.value;
      // @ts-ignore
      this.patient?.pregnant = this.patientForm.get('pregnant')?.value;
      // @ts-ignore
      this.patient?.birthDate = this.patientForm.get('birthday')?.value;
      // @ts-ignore
      this.patient?.sex = this.patientForm.get('gender')?.value;
      console.log(this.patient);
      if (this.patient) {
        this.patientService.createPatient(this.patient).subscribe({
          next: result => {
            this.router.navigate(['/patients/']);

          },
          error: error => {
            this.defaultServiceErrorHandling(error);
          }
        });
      }
    }
  }

  get svnr() {
    return this.patientForm.get('svnr') as FormControl;
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
