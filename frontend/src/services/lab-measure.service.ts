import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {LabMeasure} from "../dtos/labMeasure";

const baseUri = environment.backendUrl + '/results';

@Injectable({
  providedIn: 'root'
})
export class TestResultService {

  constructor(private httpClient: HttpClient) {
  }

  getAllLabMeasures(): Observable<LabMeasure[]> {
    console.log('Load all LabMeasures');
    return this.httpClient.get<LabMeasure[]>(baseUri);
  }

  getLabMeasureById(id: number): Observable<LabMeasure> {
    console.log('Load LabMeasure by Id');
    return this.httpClient.get<LabMeasure>(baseUri + '/' + id);
  }

  createLabMeasure(labMeasure: LabMeasure): Observable<LabMeasure> {
    return this.httpClient.post<LabMeasure>(baseUri + '/', labMeasure);
  }

}
