import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Patient} from "../dtos/patient";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Disease} from "../dtos/disease";
import {DiseaseScore} from "../dtos/diseaseScore";

const baseUri = environment.backendUrl + '/diseases';

@Injectable({
  providedIn: 'root'
})
export class DiseaseService {

  constructor(private httpClient: HttpClient) { }

  /**
   * Loads all diseases
   *
   */
  getAllDiseases(): Observable<Disease[]> {
    console.log('Load all Patients');
    return this.httpClient.get<Disease[]>(baseUri);
  }

  getAnalizedDiseases(id: number): Observable<Array<DiseaseScore>[]>{
    console.log('get analized diseases for Patient:'+id);
    return this.httpClient.get<Array<DiseaseScore>[]>(baseUri);
  }

}
