import {Component, OnInit} from "@angular/core";
import {Disease} from "../../../../dtos/disease";
import {ActivatedRoute, Route} from "@angular/router";
import {DiseaseService} from "../../../../services/disease.service";

@Component({
  selector: 'app-view-by-id',
  templateUrl: './view-by-id.component.html',
  styleUrls: ['./view-by-id.component.scss']
})
export class ViewByIdComponent implements OnInit {

  disease!: Disease;
  error = false;
  errorMessage = "";

  constructor(
    private route: ActivatedRoute,
    private diseaseService: DiseaseService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      params => {
        this.diseaseService.getDiseaseById(params.get('id')).subscribe({
          next: data => {
            console.log("received disease: ", data);
            this.disease = data;
            console.log(this.disease);
          },
          error: error => {
            this.defaultServiceErrorHandling(error);
          }
        })
      }
    );

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
