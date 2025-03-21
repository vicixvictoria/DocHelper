import {Component, Input, OnInit} from "@angular/core";
import {Disease} from "../../../dtos/disease";
import {DiseaseService} from "../../../services/disease.service";
import {Router} from "@angular/router";
import {TestValueThresholdService} from "../../../services/test-value-threshold-service";
import {Thread} from "igniteui-angular-core";

@Component({
  selector: 'app-view-disease',
  templateUrl: './view-disease.component.html',
  styleUrls: ['./view-disease.component.scss']
})
export class ViewDiseaseComponent implements OnInit {
  @Input() disease: Disease | undefined;

  error = false;
  errorMessage="";
  displayedColumns: string[] = ['LabValue', 'Type', 'Weight']

  constructor(private diseaseService: DiseaseService, private router: Router, private thresholdService: TestValueThresholdService) {}

  ngOnInit(): void {
  }

  ngOnChanges(): void {
    this.loadThresholds();
  }

  loadThresholds() {
    // @ts-ignore


    if (this.disease?.diseaseName !== undefined) {

     // console.log(this.disease.diseaseName);
      // @ts-ignore
      this.thresholdService.getThresholdsByDiseaseName(this.disease.diseaseName).subscribe({

        next: thresholds => {
          console.log('received thresholds', thresholds);
          // @ts-ignore
          this.disease.threshold_DiseaseValues = thresholds;
        },
        error: (error: any) => {
          this.defaultServiceErrorHandling(error);
        }
      })

    }

  }

  deleteDisease(disease: Disease) {
    if (confirm('Disease "' + disease.diseaseName + '" wirklich löschen?')) {
      this.diseaseService.deleteDisease(disease.id).subscribe({
        next: () => {
          console.log("Deleting Disease " + disease)
          this.router.navigate(['diseases'])
        },
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
