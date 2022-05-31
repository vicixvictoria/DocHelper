import {TestResult} from "../dtos/testResult";
import {Observable} from "rxjs";
import {DiseaseScore} from "../dtos/diseaseScore";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";

const baseUri = environment.backendUrl + '/evaluation';

@Injectable({
  providedIn: 'root'
})
export class AnalysisService {

  constructor(private httpClient: HttpClient) { }

  createAnalizys(testresult: TestResult): Observable<Array<DiseaseScore>> {
    return this.httpClient.post<Array<DiseaseScore>>(baseUri + '/', testresult);
  }

}
