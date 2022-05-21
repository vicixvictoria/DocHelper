import {Component, Inject, OnInit} from '@angular/core';
import {TestResultService} from "../../../services/test-result.service";
import {TestResult} from "../../../dtos/testResult";
import {Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {PatientService} from "../../../services/patient.service";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {Patient} from "../../../dtos/patient";

@Component({
  selector: 'app-testresult-overview',
  templateUrl: './testresult-overview.component.html',
  styleUrls: ['./testresult-overview.component.scss']
})
export class TestresultOverviewComponent implements OnInit {

  error = false;
  errorMessage = '';
  // @ts-ignore
  testResults: TestResult[];
  patient: Patient;

  constructor(
    private testResultService: TestResultService,
    private router: Router,
    @Inject(MAT_DIALOG_DATA)
    private data: any
  ) {
    this.patient = this.data.patient;
  }

  ngOnInit(): void {

    this.loadTestResultsOfPatient();
  }

  public viewTestResult(id: number) {
    this.router.navigate(['/testresults/' + id + '/view']);
  }

  /**
   * Fetches all patients from the backend.
   */
  public loadTestResultsOfPatient() {
    // @ts-ignore
    this.testResultService.getTestResultsByPatientId(this.patient.id).subscribe({
      next: data => {
        console.log('received results', data);
        this.testResults = data;
        console.log(this.testResults);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
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
