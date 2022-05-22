import {Component, Inject, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TestResult} from "../../../dtos/testResult";
import {TestResultService} from "../../../services/test-result.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {LabMeasure} from "../../../dtos/labMeasure";
import {LabValue} from "../../../dtos/labValue";
import {LabValService} from "../../../services/lab-val.service";

@Component({
  selector: 'app-edit-testresult',
  templateUrl: './edit-testresult.component.html',
  styleUrls: ['./edit-testresult.component.scss']
})
export class EditTestResultComponent implements OnInit {
  error = false;
  errorMessage = '';

  testResultForm: FormGroup;
  labMeasureForm: FormGroup;
  labMeasure: LabMeasure;
  testResult: TestResult;
  labMeasures: LabMeasure[] = [];
  labValues: LabValue[] = [];

  constructor(
    private formBuilderMeasures: FormBuilder,
    private formBuilderResults: FormBuilder,
    private testResultService: TestResultService,
    private labValueService: LabValService,
    private dialogRef: MatDialogRef<EditTestResultComponent>,
    @Inject(MAT_DIALOG_DATA)
    private data: any
  ) {

    this.testResult = data.testResult;

    this.testResultForm = this.formBuilderResults.group({
      date: new FormControl(this.testResult.date, [Validators.required])
    })

    // @ts-ignore
    this.labMeasure = new LabMeasure();

    this.labMeasureForm = this.formBuilderMeasures.group(
      {
        labValue: new FormControl(this.labMeasure.labValue, [Validators.required]),
        measuredValue: new FormControl(this.labMeasure.measuredValue, [Validators.required]),
        refValueBigger: new FormControl(this.labMeasure.refValueBigger, [Validators.required]),
        refValueLower: new FormControl(this.labMeasure.refValueLower, [Validators.required]),
        refValueFrom: new FormControl(this.labMeasure.refValueFrom, [Validators.required]),
        refValueTo: new FormControl(this.labMeasure.refValueTo, [Validators.required])
      }
    )

    this.labMeasures = data.testResult.labMeasures;

  }


  ngOnInit(): void {
    this.getAllLabValues();
  }

  editTestResult(): void {
    console.log('Edit Test Result')
    if (this.testResultForm.valid) {
      this.testResult.date = this.testResultForm.get('date')?.value;
      this.testResult.labMeasures = this.labMeasures;
      console.log(this.labMeasures);
      console.log(this.testResult);

      if (this.testResult) {
        this.testResultService.updateTestResult(this.testResult).subscribe(
          {
            next: TestResult => {
              this.dialogRef.close();
            },
            error: error => {
              this.defaultServiceErrorHandling(error);
            }
          }
        )
      }

    }
  }

  removeMeasureFromLabMeasures(measure: LabMeasure): void {
    this.labMeasures = this.labMeasures.filter((obj) => {
      return obj != measure;
    });
  }

  addLabMeasure(){

    // @ts-ignore
    this.labMeasure = new LabMeasure();
    // @ts-ignore

    console.log("add labMeasure")
    if (this.labMeasureForm.valid) {
      // @ts-ignore

      //for --> lop to go through all labVal fields

      let labValueName = this.labMeasureForm.get('labValue')?.value
      let result = this.labValues.filter((obj) => {
        return obj.labValName == labValueName;
      });


      // @ts-ignore
      this.labMeasure?.labValue = result.pop();

      // @ts-ignore
      this.labMeasure?.measuredValue = this.labMeasureForm.get('measuredValue')?.value;
      if( this.labMeasureForm.get('refValueBigger')?.value != null) {
        // @ts-ignore
        this.labMeasure?.refValueBigger = this.labMeasureForm.get('refValueBigger')?.value;
      }

      if(this.labMeasureForm.get('refValueLower')?.value != null) {
        // @ts-ignore
        this.labMeasure?.refValueLower = this.labMeasureForm.get('refValueLower')?.value;
      }
      if(this.labMeasureForm.get('refValueFrom')?.value != null) {
        // @ts-ignore
        this.labMeasure?.refValueFrom = this.labMeasureForm.get('refValueFrom')?.value;
        // @ts-ignore
        this.labMeasure?.refValueTo = this.labMeasureForm.get('refValueTo')?.value;
      }

      if (this.labMeasure instanceof LabMeasure) {
        console.log(this.labMeasure);
        this.labMeasures?.push(this.labMeasure);

      }
    }
  }

  private getAllLabValues(){
    this.labValueService.getAllLabVals().subscribe({
      next: data => {
        console.log('received LabValues', data);
        this.labValues = data;
        console.log(this.labValues);
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
