import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})



export class PatientComponent implements OnInit {

  displayedColumns: string[] = ['name', 'address', 'svnr', 'birthday'];

  patientData: Patient[] = [
    {id: 1, name: 'maria', address: 'weg 4', svnr: 1234567890, tests: [1], birthday: new Date(1999,1,1)},
    {id: 2, name: 'hans', address: 'weg 7', svnr: 1234567890, tests: [1], birthday: new Date(2000,1,1)},
    {id: 3, name: 'heri', address: 'weg 122', svnr: 1234567890, tests: [1], birthday: new Date(1999,1,1)},
    {id: 4, name: 'karl', address: 'weg 412', svnr: 1234567890, tests: [1], birthday: new Date(2000,1,1)},
    {id: 5, name: 'anna', address: 'weg 421', svnr: 1234567890, tests: [1], birthday: new Date(2001,1,1)},
    {id: 6, name: 'josephine', address: 'weg 4234', svnr: 1234567890, tests: [1], birthday: new Date(1998,1,1)},
    {id: 7, name: 'leopoldine', address: 'weg 76', svnr: 1234567890, tests: [1], birthday: new Date(1998,6,1)},
    {id: 8, name: 'hansi', address: 'weg 76', svnr: 1234567890, tests: [1], birthday: new Date(1998,6,1)},
    {id: 9, name: 'fritz', address: 'weg 8', svnr: 1234567890, tests: [1], birthday: new Date(1998,4,1)},
    {id: 10, name: 'martina', address: 'weg 8', svnr: 1234567890, tests: [1], birthday: new Date(1980,3,1)},
    {id: 11, name: 'olivia', address: 'weg 8', svnr: 1234567890, tests: [1], birthday: new Date(1970,5,1)}
  ]


  ngOnInit(): void {
  }

}
