import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Disease} from "../dtos/disease";

const baseUri = environment.backendUrl + '/diseases';

@Injectable({
  providedIn: 'root'
})
export class DiseaseService {

  constructor(private httpClient: HttpClient) { }

  /**
   * Loads all diseases
   *
   */
  getAllDiseases(): Observable<Disease[]> {
    console.log('Load all Patients');
    return this.httpClient.get<Disease[]>(baseUri);
  }

  getDiseaseById(id: string | null): Observable<Disease> {
    console.log('Load diseases');
    return this.httpClient.get<Disease>(baseUri + '/' + id);
  }

  createDisease(disease: Disease): Observable<Disease> {
    console.log('Add disease', disease);
    return this.httpClient.post<Disease>(baseUri + '/', disease);
  }

  deleteDisease(id: number): Observable<Disease> {
    return this.httpClient.delete<Disease>(baseUri + '/' + id);
  }

}
