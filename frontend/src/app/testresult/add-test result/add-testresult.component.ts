import {Component, Inject, Input, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TestResult} from "../../../dtos/testResult";
import {TestResultService} from "../../../services/test-result.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {LabMeasure} from "../../../dtos/labMeasure";
import {AddLabMeasureComponent} from "../add-labmeasure/add-labmeasure.component";
import {LabValue} from "../../../dtos/labValue";
import {LabValService} from "../../../services/lab-val.service";
import {LabMeasureService} from "../../../services/lab-measure.service";

@Component({
  selector: 'app-add-testresult',
  templateUrl: './add-testresult.component.html',
  styleUrls: ['./add-testresult.component.scss']
})
export class AddTestResultComponent implements OnInit {
  error = false;
  errorMessage ='';

  testResultForm: FormGroup;
  labMeasureForm: FormGroup;
  labMeasure: LabMeasure | undefined;
  testResult: TestResult | undefined;
  labMeasures: LabMeasure[] = [];
  labValues: LabValue[] = [];

  constructor(
    private formBuilderResults: FormBuilder,
    private formBuilderMeasures: FormBuilder,
    private testResultService: TestResultService,
    private router: Router,
    private dialogRef: MatDialogRef<AddTestResultComponent>,
    @Inject(MAT_DIALOG_DATA)
    private data: any,
    private readonly dialog: MatDialog,
    private labValueService: LabValService,
  ) {



    // @ts-ignore
    this.testResult =  new TestResult();

    this.testResultForm = this.formBuilderResults.group(
      {
        date: new FormControl(this.testResult.date, [Validators.required]),
      }
    )

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

  }

  ngOnInit(): void {
    this.getAllLabValues();
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
        //this.labMeasureService.createLabMeasure(this.labMeasure);
        this.labMeasures?.push(this.labMeasure);

      }
    }
  }


  addTestResult(): void {
    console.log("add test result");
    if (this.testResultForm.valid) {

      // @ts-ignore
      this.testResult?.date = this.testResultForm.get('date')?.value;
      // @ts-ignore
      this.testResult?.labMeasures = this.labMeasures;
      // @ts-ignore
      this.testResult?.patientId = this.data.patientId;
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
