import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {TestValueThreshold} from "../dtos/testValueThreshold";

const baseUri = environment.backendUrl + '/thresholds';

@Injectable({
  providedIn: 'root'
})
export class TestValueThresholdService {

  constructor(private httpClient: HttpClient) { }

  createThresholds(thresholds: TestValueThreshold[]): Observable<TestValueThreshold[]> {
    console.log('add thresholds');
    return this.httpClient.post<TestValueThreshold[]>(baseUri + '/', thresholds);
  }

  getThresholdsByDiseaseName(diseaseName: String): Observable<TestValueThreshold[]> {
    console.log('get thresholds');
    return this.httpClient.get<TestValueThreshold[]>(baseUri + '/' + diseaseName);
  }
}
