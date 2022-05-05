import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {PatientComponent} from "./patient/patient.component";
import {TestResult} from "../dtos/testResult";
import {TestresultDetailComponent} from "./testresult-detail/testresult-detail.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'patients', component: PatientComponent},
  {path: 'testresults/:id/view', component: TestresultDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
