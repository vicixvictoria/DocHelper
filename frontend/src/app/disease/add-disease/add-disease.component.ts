import {Component, Inject, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Disease} from "../../../dtos/disease";
import {TestValueThreshold} from "../../../dtos/testValueThreshold";
import {LabValue} from "../../../dtos/labValue";
import {TestResultService} from "../../../services/test-result.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {LabValService} from "../../../services/lab-val.service";
import {DiseaseService} from "../../../services/disease.service";
import {Type} from "../../../global/type";
import {TestValueThresholdService} from "../../../services/test-value-threshold-service";

@Component({
  selector: 'app-add-disease',
  templateUrl: './add-disease.component.html',
  styleUrls: ['add-disease.component.scss']
})
export class AddDiseaseComponent implements OnInit {

  error = false;
  errorMessage = '';

  diseaseForm: FormGroup;
  thresholdsForm: FormGroup;
  disease: Disease | undefined;
  threshold: TestValueThreshold | undefined;
  thresholds: TestValueThreshold[] = [];
  labValues: LabValue[] = [];

  constructor(
    private formBuilderDisease: FormBuilder,
    private formBuilderThresholds: FormBuilder,
    private diseaseService: DiseaseService,
    private router: Router,
    private dialogRef: MatDialogRef<AddDiseaseComponent>,
    @Inject(MAT_DIALOG_DATA)
    private data: any,
    private readonly dialog: MatDialog,
    private labValueService: LabValService,
    private thresholdService: TestValueThresholdService
  ) {

    // @ts-ignore
    this.disease = new Disease();

    this.diseaseForm = this.formBuilderDisease.group({
      diseaseName: new FormControl(this.disease.diseaseName, [Validators.required]),
      icdCode: new FormControl(this.disease.icdCode, [Validators.required,  Validators.pattern('[A-Z][0-9][0-9].[0-9]'), Validators.minLength(5), Validators.maxLength(5)]),
      description: new FormControl(this.disease.description, [Validators.required]),
      pregnant: new FormControl(this.disease.pregnant, []),
      minAge: new FormControl(this.disease.minAge, [Validators.pattern('[0-9][0-9]?'), Validators.minLength(1), Validators.maxLength(2)]),
      maxAge: new FormControl(this.disease.maxAge, [Validators.pattern('[0-9][0-9]?'), Validators.minLength(1), Validators.maxLength(2)]),
      threshold: new FormControl(this.disease.threshold, [Validators.required, Validators.pattern('[0-9]*')])
    })

    // @ts-ignore
    this.threshold = new TestValueThreshold();

    this.thresholdsForm = this.formBuilderThresholds.group({
      type: new FormControl(this.threshold.type, [Validators.required]),
      refVal_overwrite: new FormControl(this.threshold.refVal_overwrite, []),
      weightValue: new FormControl(this.threshold.weightValue, [Validators.required, Validators.pattern('[0-9]*')]),
      labVal: new FormControl(this.threshold.labVal, [Validators.required])
    })

  }

  ngOnInit(): void {
    this.getAllLabValues();
  }


  removeThresholdFromThresholds(threshold: TestValueThreshold): void {
    this.thresholds = this.thresholds.filter((obj ) => {
      return obj.labValName != threshold.labValName;
    });
  }


  addDisease(): void {
    console.log('add disease')

    // @ts-ignore
    this.disease?.diseaseName = this.diseaseForm.get('diseaseName')?.value;
    // @ts-ignore
    this.disease?.icdCode = this.diseaseForm.get('icdCode')?.value;
    // @ts-ignore
    this.disease?.description = this.diseaseForm.get('description')?.value;
    // @ts-ignore
    this.disease?.pregnant = this.diseaseForm.get('pregnant')?.value != null;
    // @ts-ignore
    this.disease?.minAge = this.diseaseForm.get('minAge')?.value;
    // @ts-ignore
    this.disease?.maxAge = this.diseaseForm.get('maxAge')?.value;
    // @ts-ignore
    this.disease?.threshold = this.diseaseForm.get('threshold')?.value;


    this.thresholds.forEach((it) => {
      // @ts-ignore
      it.diseaseName = this.disease.diseaseName;
    })


    this.thresholdService.createThresholds(this.thresholds).subscribe({
      next: thresholds => {
        console.log(thresholds)
        // @ts-ignore
        this.disease?.threshold_DiseaseValues = thresholds;
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    })

    console.log(this.disease);


    if (this.disease) {
      this.diseaseService.createDisease(this.disease).subscribe({
        next: disease => {
          this.dialogRef.close();
        },
        error: error => {
          this.defaultServiceErrorHandling(error);
        }
      })
    }



  }

  addThreshold(): void {
    console.log('add threshold');

    let labValName = this.thresholdsForm.get('labVal')?.value
    let result = this.labValues.filter((obj) => {
      return obj.labValName == labValName;
    });
    // @ts-ignore
    this.threshold?.labVal = result.pop();
    // @ts-ignore
    this.threshold?.labValName = labValName;

    if (this.thresholdsForm.get('refVal_overwrite')?.value != null) {
      // @ts-ignore
      this.threshold?.refVal_overwrite = this.thresholdsForm.get('refVal_overwrite')?.value
    } else {
      // @ts-ignore
      this.threshold?.refVal_overwrite = undefined
    }

    // @ts-ignore
    this.threshold?.type = this.thresholdsForm.get('type')?.value

    // @ts-ignore
    this.threshold?.weightValue = this.thresholdsForm.get('weightValue')?.value


    if (this.threshold instanceof TestValueThreshold) {
      this.thresholds.push(this.threshold)
    }

  }

  typeNames(): Array<String> {
    return Object.keys(Type);
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
