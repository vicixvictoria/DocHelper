import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TestResult} from "../../../dtos/testResult";
import {TestResultService} from "../../../services/test-result.service";
import {MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-testresult',
  templateUrl: './add-testresult.component.html',
  styleUrls: ['./add-testresult.component.scss']
})
export class AddTestResultComponent implements OnInit {
  error = false;
  errorMessage ='';

  testResultForm: FormGroup;
  testResult: TestResult | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private testResultService: TestResultService,
    private router: Router,
    private dialogRef: MatDialogRef<AddTestResultComponent>
  ) {

    // @ts-ignore
    this.testResult =  new TestResult();

    this.testResultForm = this.formBuilder.group(
      {
        date: new FormControl(this.testResult.date, [Validators.required]),
        patientId: 3,
        labMeasures: null,
      }
    )

  }

  ngOnInit(): void {
  }

  addTestResult(): void {
    console.log("ad test result");
    if (this.testResultForm.valid) {
      // @ts-ignore
      this.testResult?.date = this.testResultForm.get('date')?.value;
      // @ts-ignore
      this.testResult?.labMeasures = this.testResultForm.get('labMeasures')?.value;
      // @ts-ignore
      this.testResult?.patientId = this.testResultForm.get('patientId')?.value;
      console.log(this.testResult);
      if (this.testResult) {
        this.testResultService.createTestResult(this.testResult).subscribe(
          {
            next: testResult => {
              this.dialogRef.close();
            },
            error: error => {
              this.defaultServiceErrorHandling(error);
            }
          })
      }
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
