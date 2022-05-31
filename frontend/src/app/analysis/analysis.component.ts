import {Component, Input, OnInit} from '@angular/core';
import {DiseaseService} from "../../services/disease.service";
import {MatDialog} from "@angular/material/dialog";
import {ViewChild } from "@angular/core";
import {
  ApexAxisChartSeries,
  ApexChart,
  ChartComponent,
  ApexDataLabels,
  ApexXAxis,
  ApexPlotOptions,
  ApexStroke,
  ApexNonAxisChartSeries
} from "ng-apexcharts";
import {DiseaseScore} from "../../dtos/diseaseScore";
import {Disease} from "../../dtos/disease";
import {ActivatedRoute} from "@angular/router";
import {Patient} from "../../dtos/patient";
import {TestResult} from "../../dtos/testResult";
import {AnalysisService} from "../../services/analysis.service";
import {TestResultService} from "../../services/test-result.service";

export type ChartOptions = {
  series: ApexAxisChartSeries| any;
  chart: ApexChart |any;
  dataLabels: ApexDataLabels| any;
  plotOptions: ApexPlotOptions| any;
  xaxis: ApexXAxis| any;
  stroke: ApexStroke |any ;
};


@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css'],
})
export class AnalysisComponent implements OnInit {

  @ViewChild("chart") chart: ChartComponent | undefined;
  // @ts-ignore
  public chartOptions: Partial<ChartOptions>;

  error = false;
  errorMessage = '';
  // @ts-ignore
  analizedDiseases1: Array<Disease>;
  // @ts-ignore
  analizedDiseases2: Array<number>;
  // @ts-ignore
  analizedDiseases: DiseaseScore[];
  // @ts-ignore
  datas: Array[];
  //dataD: DiseaseScore[];
  // @ts-ignore
  testResultId: number;
  // @ts-ignore
  testResult: Observable<TestResult>;
  // @ts-ignore
  data2: Disease[] = {};
  // @ts-ignore
  data3: number[] = {};

  dataDname: any[] = [];
  dataDthreshold: any[] =[];
  dataScore: any[] = [];

  displayedColumns: string[] = ['diseaseName', 'threshold'];
  translations: string[] = ['Name', 'Threshold'];
  private dataDisease: Disease[] = [];
  private dataNumber: number[] = [];


  constructor(
    private readonly dialog: MatDialog,
    private diseaseService: DiseaseService,
    private route: ActivatedRoute,
    private analysisService: AnalysisService,
    private testResultService: TestResultService
  ) {

  }

  ngOnInit(): void {

    this.route.queryParams.subscribe(
      params => {
        this.testResultId = params['id'];
      }
    )

    this.loadTestResultsById(this.testResultId);
    console.log(this.testResultId);

  }


  public loadTestResultsById(id: number) {
    // @ts-ignore
    this.testResultService.getTestResultById(id).subscribe({
      next: data => {
        console.log('received testResult:', data);
        this.testResult = data;
        console.log(this.testResult);
        this.loadAnalizedDiseases(this.testResult);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  public loadAnalizedDiseases(testresult: TestResult){
    this.analysisService.createAnalizys(testresult).subscribe({
      next: data1 => {
        console.log('received analized Diseases', data1);
        this.analizedDiseases = data1;
        console.log('analized', this.analizedDiseases);
        for(let i=0; i<this.analizedDiseases.length; i++){
          console.log(this.analizedDiseases[i].disease.diseaseName);
          this.data2[i] = this.analizedDiseases[i].disease;
          this.data3[i] = this.analizedDiseases[i].score;
          this.dataDisease[i] = this.data2[i];
          this.dataNumber[i] = this.data3[i];
        }
        this.analysis(this.dataNumber, this.dataDisease);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  public analysis(data3: number[], data2: Disease[]){
    console.log('test' + data2);
    let dataScore = [];
    //console.log(dataScore);
    //let dataDthreshold = [];

    for (let i = 0; i <data2.length; i++) {
      // @ts-ignore
      this.dataDname[i] = data2[i].diseaseName;
      // @ts-ignore
      this.dataDthreshold[i] = data2[i].threshold;
      console.log('test' + this.dataDthreshold);
      // @ts-ignore
      this.dataScore[i] = data3[i];
    }

    console.log(this.dataDthreshold);
    console.log(this.dataScore);
    console.log(this.dataDname)

    // @ts-ignore
    this.chartOptions = {
      series: [
        {
          name: "Krankheit",
          data: this.dataScore,
        },
        {
          name: "Threshold",

          data: this.dataDthreshold,
        }
      ],
      chart: {
        type: "bar",
        height: 430
      },
      plotOptions: {
        bar: {
          horizontal: true,
          dataLabels: {
            position: "top"
          }
        }
      },
      dataLabels: {
        enabled: true,
        offsetX: -6,
        style: {
          fontSize: "12px",
          colors: ["#fff"]
        }
      },
      stroke: {
        show: true,
        width: 1,
        colors: ["#fff"]
      },
      xaxis: {
        categories: this.dataDname
      }
    };
  }

  private defaultServiceErrorHandling(error: any){
    console.log(error);
    this.error = true;
    if (error.status === 0) {
      // If status is 0, the backend is probably down
      this.errorMessage = 'The backend seems not to be reachable';
    }  else if (error.error.message === 'No message available') {
      // If no detailed error message is provided, fall back to the simple error name
      this.errorMessage = error.error.error;
   } else {
      this.errorMessage = error.error.message;
   }
}

}
