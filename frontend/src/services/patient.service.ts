import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "../dtos/patient";
import {environment} from "../environments/environment";

const baseUri = environment.backendUrl + '/patients';

class Oberservable<T> {
}

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient: HttpClient) {
  }


  /**
   * Loads specific patient from the backend
   *
   * @param id of patient to load
   */
    getPatientById(id: number): Observable<Patient> {
      console.log('Load Patient details for id: ' + id);
      return this.httpClient.get<Patient>(baseUri + '/' + id);
    }

  /**
   * Loads all patients
   *
   */
    getAllPatients(): Observable<Patient[]> {
      console.log('Load all Patients');
      return this.httpClient.get<Patient[]>(baseUri);
    }

  /**
   * edit Patient
   *
   * @param patient to be edit with updated data
   */
  editPatient(patient: Patient): Observable<Patient> {
    return this.httpClient.put<Patient>(baseUri + '/', patient);
  }

  /**
   * edit Patient
   *
   * @param patient to be created
   */
  createPatient(patient: Patient): Observable<Patient> {
    return this.httpClient.post<Patient>(baseUri + '/', patient);
  }

  /**
   * Deletes the patient with the id from the backend
   *
   * @param id of the patient to be deleted
   */
  deletePatient(id: number): Observable<Patient> {
    return this.httpClient.delete<Patient>(baseUri + '/' + id);
  }

}
