import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {Patient} from "../dtos/patient";
import {HttpClient} from "@angular/common/http";
import {TestResult} from "../dtos/testResult";
import {LabValue} from "../dtos/labValue";

const baseUri = environment.backendUrl + '/labValues';

@Injectable({
  providedIn: 'root'
})
export class LabValService {

  constructor(private httpClient: HttpClient) {
  }

  getAllLabVals(): Observable<LabValue[]> {
    console.log('Load all LabVals');
    return this.httpClient.get<LabValue[]>(baseUri);
  }

  createLabValue(labValue: LabValue): Observable<LabValue> {
    return this.httpClient.post<LabValue>(baseUri + '/', labValue);
  }

  deleteLabValue(id: number): Observable<LabValue> {
    return this.httpClient.delete<LabValue>(baseUri + '/' + id);
  }

}
