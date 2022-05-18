import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TestResult} from "../../../dtos/testResult";
import {AddTestResultComponent} from "../add-test result/add-testresult.component";
import {TestResultService} from "../../../services/test-result.service";
import {MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {LabMeasure} from "../../../dtos/labMeasure";
import {LabValService} from "../../../services/lab-val.service";
import {LabValue} from "../../../dtos/labValue";

@Component({
  selector: 'app-add-labmeasure',
  templateUrl: './add-labmeasure.component.html'
  //styleUrls: ['./add-labmeasure.component.scss']
})
export class AddLabMeasureComponent implements OnInit {
  error = false;
  errorMessage ='';

  labMeasureForm: FormGroup;
  labMeasure: LabMeasure | undefined;
  labVals: LabValue[] | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private testResultService: TestResultService,
    private router: Router,
    private dialogRef: MatDialogRef<AddLabMeasureComponent>,
    private labValService: LabValService
  ) {

    // @ts-ignore
    this.labMeasure = new LabMeasure();

    this.labMeasureForm = this.formBuilder.group(
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
  }


  addLabMeasures(): void {
    console.log("add labmeassures")
    if (this.labMeasureForm.valid) {
      // @ts-ignore

      //for --> lop to go through all labVal fields

      this.labMeasure?.labValue = this.labMeasureForm.get('labvalue')?.value;
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

    }

  }

  public getAllLabVals(){
    this.labValService.getAllLabVals().subscribe({
      next: data => {
        console.log('received LabVals', data);
        this.labVals = data;
        this.labVals = this.labVals.sort((a, b) => a.labValName.localeCompare(b.labValName));
        console.log(this.labVals);
      }
    })
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
