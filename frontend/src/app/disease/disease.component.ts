import { Component, OnInit } from '@angular/core';
import {Patient} from "../../dtos/patient";
import {Disease} from "../../dtos/disease";
import {DiseaseService} from "../../services/disease.service";
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-disease',
  templateUrl: './disease.component.html',
  styleUrls: ['./disease.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class DiseaseComponent implements OnInit {

  error = false;
  errorMessage = '';
  // @ts-ignore
  diseases: Disease[];

  displayedColumns: string[] = ['icdCode', 'name', 'age', 'pregnant', 'aktion'];
  translations: string[] = ['ICD Code', 'Name', 'Alter', 'Schwanger', 'Aktion'];
  // @ts-ignore
  expandedElement: Disease |  null;

  constructor(
    private diseaseService: DiseaseService,
  ) { }

  ngOnInit(): void {
    this.loadAllDiseases();
  }

  /**
   * Fetches all diseases from the backend.
   */
  public loadAllDiseases() {
    this.diseaseService.getAllDiseases().subscribe({
      next: data => {
        console.log('received diseases', data);
        this.diseases = data;
        console.log(this.diseases);
      },
      error: error => {
        this.defaultServiceErrorHandling(error);
      }
    });
  }

  deleteDisease(disease: Disease) {
    if (confirm('Disease "' + disease.diseaseName + '" wirklich löschen?')) {
      this.diseaseService.deleteDisease(disease.id).subscribe({
        next: () => {
          console.log("Deleting Disease " + disease)
          this.loadAllDiseases();
        }
        ,
        error: (error: any) => {
          this.defaultServiceErrorHandling(error);
        }
      });
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
