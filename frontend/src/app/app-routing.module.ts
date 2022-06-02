import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {PatientComponent} from "./patient/patient.component";
import {TestResult} from "../dtos/testResult";
import {TestresultDetailComponent} from "./testresult/testresult-detail/testresult-detail.component";
import {DiseaseComponent} from "./disease/disease.component";
import {TestresultOverviewComponent} from "./testresult/testresult-overview/testresult-overview.component";
import {LabValueComponent} from "./lab-value/lab-value.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'patients', component: PatientComponent},
  {path: 'testresults/:id/view', component: TestresultDetailComponent},
  {path: 'diseases', component: DiseaseComponent},
  {path: 'testresultsoverview', component: TestresultOverviewComponent},
  {path: 'labvalue', component: LabValueComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
