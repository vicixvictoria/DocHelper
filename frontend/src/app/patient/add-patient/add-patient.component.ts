import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Patient} from "../../../dtos/patient";
import {PatientService} from "../../../services/patient.service";

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
})
export class AddPatientComponent implements OnInit {

  patientForm: FormGroup;
  patient: Patient | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private patientService: PatientService
  ) {
    // @ts-ignore
    this.patient = new Patient();
    this.patient.pregnant = false;

    this.patientForm  = this.formBuilder.group({
      firstname: new FormControl(this.patient.firstname, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      lastname: new FormControl(this.patient.lastname, [
        Validators.required, Validators.minLength(1), Validators.maxLength(64)]),
      svnr: new FormControl(this.patient.svnr, [
        Validators.required,  Validators.pattern('[0-9]*'), Validators.minLength(10), Validators.maxLength(10)]),
      pregnant: new FormControl(this.patient.pregnant, []),
      birthday: new FormControl(this.patient.birthday, [
        Validators.required]),
      gender: new FormControl(this.patient.gender, [
        Validators.required])
    });
  }

  ngOnInit(): void {

  }

  addPatient(): void {
    console.log("add patient")
    if (this.patientForm.valid) {
      // @ts-ignore
      this.patient?.firstname = this.patientForm.get('firstname')?.value;
      // @ts-ignore
      this.patient?.lastname = this.patientForm.get('lastname')?.value;
      // @ts-ignore
      this.patient?.svnr = this.patientForm.get('svnr')?.value;
      // @ts-ignore
      this.patient?.pregnant = this.patientForm.get('pregnant')?.value;
      // @ts-ignore
      this.patient?.birthday = this.patientForm.get('birthday')?.value;
      // @ts-ignore
      this.patient?.gender = this.patientForm.get('gender')?.value;
      console.log(this.patient);
      if (this.patient) {
        this.patientService.createPatient(this.patient).subscribe({
          next: result => {


          },
          error: error => {
          }
        });
      }
    }
  }

}
