import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {STEPPER_GLOBAL_OPTIONS} from "@angular/cdk/stepper";
import {Patient} from "../../dtos/patient";
import {PatientService} from "../../services/patient.service";
import {map, Observable, startWith} from "rxjs";
import {MatAutocompleteTrigger} from "@angular/material/autocomplete";
import {TestResult} from "../../dtos/testResult";
import {TestResultService} from "../../services/test-result.service";
import {AddPatientComponent} from "../patient/add-patient/add-patient.component";
import {MatDialog} from "@angular/material/dialog";
import {AddTestResultComponent} from "../testresult/add-test result/add-testresult.component";
import {AnalysisComponent} from "../analysis/analysis.component";
import {DiseaseService} from "../../services/disease.service";
import {DiseaseScore} from "../../dtos/diseaseScore";
import {AnalysisService} from "../../services/analysis.service";
import {TestresultOverviewComponent} from "../testresult/testresult-overview/testresult-overview.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS,
      useValue: {showError: true},
    },
  ],
})
export class HomeComponent implements OnInit {

  patientControl = new FormControl();
  testResultControl = new FormControl();
  // @ts-ignore
  firstFormGroup: FormGroup;
  // @ts-ignore
  secondFormGroup: FormGroup;
  // @ts-ignore
  patients: Patient[];
  // @ts-ignore
  selectedPatient: Patient;
  // @ts-ignore
  filteredOptions: Observable<any[]>;
  // @ts-ignore
  testResults: TestResult[];
  error = false;
  errorMessage = '';
  // @ts-ignore
  analizedDiseases: Array<DiseaseScore>;


  // @ts-ignore
  @ViewChild(MatAutocompleteTrigger) trigger;



  constructor(private _formBuilder: FormBuilder,
              private patientService: PatientService,
              private testResultService: TestResultService,
              private diseaseService: DiseaseService,
              private analysisService: AnalysisService,
              private readonly dialog: MatDialog)
  {
  }

  ngOnInit(): void {
    this.loadAllPatients();


    this.firstFormGroup = this._formBuilder.group({
      patientControl: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      testResultControl: ['', Validators.required],
    });

    this.filteredOptions = this.patientControl.valueChanges.pipe(
      startWith(''),
      map(value => value.length >= 0?  this._filter(value): []),
    )
  }

  addPatient(){
    const dialog = this.dialog.open(AddPatientComponent, {width: '500px'});
    dialog.afterClosed().subscribe(() => {
      this.loadAllPatients();
    })
  }

  addTestResult(){
    const dialog = this.dialog.open(AddTestResultComponent, {
      data: {
        patientId: this.selectedPatient.id
      },
      width: '1500px'
      });
    dialog.afterClosed().subscribe( () => {
      this.loadTestResultsOfPatient();
    })
  }

  public onFocus() {
    this.trigger._onChange("");
    this.trigger.openPanel();
  }

  private _filter(value: string): string[] {
    const filterValue = value.toString().toLowerCase();

    // @ts-ignore
    return this.patients?.map( x => x.firstName + ' ' + x.lastName).filter(option => option.toString().toLowerCase().includes(filterValue));
  }

  public selectPatient(){
    if (this.patientControl.value !== null) {
      console.log(this.patientControl.value);
      this.selectedPatient = this.patientControl.value;
      this.loadTestResultsOfPatient()
    }
  }

  public selectTestResult(){
      console.log(this.testResultControl.value)
      //this.loadAnalizedDiseases(this.testResultControl.value);

  }

  /*public loadAnalizedDiseases(testresult: TestResult){
    console.log("analize Diseases");
    this.analysisService.createAnalizys(testresult).subscribe({
      next: data1 => {
        console.log('received analized Diseases', data1);
        this.analizedDiseases = data1;
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
    this.analysisService.diseasescore = this.analizedDiseases;
  }*/

  /**
   * Fetches all patients from the backend.
   */
  public loadTestResultsOfPatient() {
    // @ts-ignore
    this.testResultService.getTestResultsByPatientId(this.selectedPatient.id).subscribe({
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

  /**
   * Fetches all patients from the backend.
   */
  public loadAllPatients() {
    this.patientService.getAllPatients().subscribe({
      next: data => {
        console.log('received patients', data);
        this.patients = data;
        this.patients = this.patients.sort((a, b) => a.firstName.localeCompare(b.firstName));
        console.log(this.patients);
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
