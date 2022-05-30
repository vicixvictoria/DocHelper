import { Component, OnInit } from '@angular/core';
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
  public chartOptions: Partial<ChartOptions>;

  error = false;
  errorMessage = '';
  // @ts-ignore
  analizedDiseases1: Array<DiseaseScore>;
  // @ts-ignore
  analizedDiseases2: Array<DiseaseScore>;
  // @ts-ignore
  analizedDiseases: Array<DiseaseScore>;
  // @ts-ignore
  datas: Array[];
  //dataD: DiseaseScore[];
  // @ts-ignore
  testResult: TestResult;




  constructor(
    private readonly dialog: MatDialog,
    private diseaseService: DiseaseService,
    private route: ActivatedRoute,
  ) {

    this.route.queryParams.subscribe(
      params => {
        this.analizedDiseases1 = params['disease'];
        this.analizedDiseases2 = params['score'];
      }
    )
    // @ts-ignore
    let dataD= this.analizedDiseases1;
    // @ts-ignore
    let dataS= this.analizedDiseases2;
    /*let dataD: number [] [] = [[40, 20],
      [30, 40],
      [10,80]
    ];*/
    let dataDname = [];
    let dataScore = [];
    let dataDthreshold = [];


   for(let i=0; i< dataD.length; i++){
     let dat1= dataD[i].disease
     let dat2= dataS[i].score
     dataDname.push(dat1.diseaseName);
     dataDthreshold.push(dat1.threshold)
     dataScore.push(dat2);
   }

    // @ts-ignore
    this.chartOptions = {
      series: [
        {
          name: "Krankheit",
          data: dataDthreshold,
        },
        {
          name: "Threshold",

          data: dataScore,
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
        categories: dataDname
      }
    };
  }

  ngOnInit(): void {

    /*this.loadAnalizedDiseases(this.testResult);
    this.analizedDiseases1=this.analizedDiseases;*/
  }

  /*public loadAnalizedDiseases(testResult: TestResult){
    this.diseaseService.createAnalizys(testResult).subscribe({
      next: data1 => {
        console.log('received analized Diseases', data1);
        this.analizedDiseases = data1;
        console.log(this.analizedDiseases);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }*/

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
