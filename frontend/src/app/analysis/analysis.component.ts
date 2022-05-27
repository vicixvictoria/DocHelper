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
  analizedDiseases1: Array<DiseaseScore>[];
  // @ts-ignore
  analizedDiseases: Array<DiseaseScore>[];
  id = 1;
  // @ts-ignore
  datas: Array[];
  //dataD: DiseaseScore[];




  constructor(
    private readonly dialog: MatDialog,
    private diseaseService: DiseaseService,
  ) {
    // @ts-ignore
    let dataD= this.analizedDiseases1;
    /*let dataD: number [] [] = [[40, 20],
      [30, 40],
      [10,80]
    ];*/
    let dataDname = [];
    let dataScore = [];
    let dataDthreshold = [];


   for(let i=0; i< dataD.length; i++){
     let dat1= dataD[i][0]
     let dat2= dataD[i][1]
     dataDname.push(dat1.disease.diseaseName);
     dataDthreshold.push(dat1.disease.threshold)
     dataScore.push(dat2.score);
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
    this.loadAnalizedDiseases(this.id);
    this.analizedDiseases1=this.analizedDiseases;
  }

  public loadAnalizedDiseases(id: number){
    this.diseaseService.getAnalizedDiseases(id).subscribe({
      next: data1 => {
        console.log('received analized Diseases', data1);
        this.analizedDiseases = data1;
        console.log(this.analizedDiseases);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
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
