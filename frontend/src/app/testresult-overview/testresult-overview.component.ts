import { Component, OnInit } from '@angular/core';
import {TestResultService} from "../../services/test-result.service";
import {TestResult} from "../../dtos/testResult";
import {Router} from "@angular/router";

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

  constructor(
    private testResultService: TestResultService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadAllPatients();
  }

  public viewTestResult(id: number) {
    this.router.navigate(['/testresults/' + id + 'view']);
  }

  /**
   * Fetches all patients from the backend.
   */
  public loadAllPatients() {
    this.testResultService.getAllTestResults().subscribe({
      next: data => {
        console.log('received patients', data);
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
