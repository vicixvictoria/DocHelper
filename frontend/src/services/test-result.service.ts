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
   * Loads Testresult by Id
   *
   */
  getTestResultById(id: number): Observable<TestResult> {
    console.log('Load TestResult by Id');
    return this.httpClient.get<TestResult>(baseUri + '/' + id);
  }

  /**
   * Loads all Testresults of a Patient
   *
   *
   * @param id of Patient
   */
  getTestResultsByPatientId(id: number): Observable<TestResult[]> {
    console.log('Load TestResults of patien with id ' + id);
    return this.httpClient.get<TestResult[]>(baseUri + '/patients/' + id);
  }

  createTestResult(testResult: TestResult): Observable<TestResult> {
    return this.httpClient.post<TestResult>(baseUri + '/', testResult);
  }

  /**
   * Deletes the testresult with the id from the backend
   *
   * @param id of the testresult to be deleted
   */
  deleteTestResult(id: number): Observable<TestResult> {
    return this.httpClient.delete<TestResult>(baseUri + '/' + id);
  }
}
