import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "../dtos/patient";
import {environment} from "../environments/environment";

const baseUri = environment.backendUrl + '/patients ';

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

}
