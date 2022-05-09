import { Injectable } from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {Patient} from "../dtos/patient";
import {HttpClient} from "@angular/common/http";
import {TestResult} from "../dtos/testResult";

const baseUri = environment.backendUrl + '/results';

@Injectable({
  providedIn: 'root'
})
export class TestResultService {

  constructor(private httpClient: HttpClient) { }

  /**
   * Loads all Testresults
   *
   */
  getAllTestResults(): Observable<TestResult[]> {
    console.log('Load all TestResults');
    return this.httpClient.get<TestResult[]>(baseUri);
  }

  /**
   * Loads all Testresults of a Patien
   *
   *
   * @param id of Patient
   */
  getTestResultsByPatientId(id: number): Observable<TestResult[]> {
    console.log('Load TestResults of patien with id ' + id);
    return this.httpClient.get<TestResult[]>(baseUri + '/' + id);
  }
}
