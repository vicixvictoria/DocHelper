import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {TestResult} from "../../dtos/testResult";
import {PatientService} from "../../services/patient.service";
import {TestResultService} from "../../services/test-result.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-testresult-detail',
  templateUrl: './testresult-detail.component.html',
  styleUrls: ['./testresult-detail.component.scss']
})
export class TestresultDetailComponent implements OnInit {

  // @ts-ignore
  patient: Patient;
  // @ts-ignore
  testResult: TestResult;
  // @ts-ignore
  testResultId: number;

  error = false;
  errorMessage = '';

  constructor(
    private patientService: PatientService,
    private testResultService: TestResultService,
    private router: Router,
    private route: ActivatedRoute
  )
  {

  }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    this.testResultId = Number(routeParams.get('id'));
    this.loadTestResultsById(this.testResultId);

  }


  public loadPatientById(id: number) {
    // @ts-ignore
    this.patientService.getPatientById(id).subscribe({
      next: data => {
        console.log('received patient', data);
        this.patient = data;
        console.log(this.patient);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  public loadTestResultsById(id: number) {
    // @ts-ignore
    this.testResultService.getTestResultById(id).subscribe({
      next: data => {
        console.log('received testResult:', data);
        this.testResult = data;
        console.log(this.testResult);
        this.loadPatientById(this.testResult.patientId);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  /**
   * Deletes testresult from the backend.
   *
   * @param testresult to be deleted.
   */
  deleteTestResult(testResult: TestResult) {
    if (confirm('Befund vom ' + this.testResult.date + ' von Patient "' + this.patient?.firstName + ' ' + this.patient?.lastName + '" wirklich löschen?')) {
      this.testResultService.deleteTestResult(this.testResult.id).subscribe({
        next: () => {
          console.log("Deleting testresult " + this.testResult)
          this.router.navigate(['home']);
        }
        ,
        error: error => {
          this.defaultServiceErrorHandling(error);
        }
      });
    }
  }

  private defaultServiceErrorHandling(error: any) {
    console.log(error);
    this.error = true;
    if (error.status === 0) {
      // If status is 0, the backend is probably down
      this.errorMessage = 'The backend seems not to be reachable';
    } else if (error.error.message === 'No message available') {
      // If no detailed error message is provided, fall back to the simple error name
      this.errorMessage = error.error.error;
    } else {
      this.errorMessage = error.error.message;
    }
  }
}
