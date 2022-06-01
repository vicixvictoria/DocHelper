import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {PatientComponent} from "./patient/patient.component";
import {TestresultDetailComponent} from "./testresult/testresult-detail/testresult-detail.component";
import {DiseaseComponent} from "./disease/disease.component";
import {TestresultOverviewComponent} from "./testresult/testresult-overview/testresult-overview.component";
import {ViewByIdComponent} from "./disease/view-disease/view-by-id/view-by-id.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'patients', component: PatientComponent},
  {path: 'testresults/:id/view', component: TestresultDetailComponent},
  {path: 'diseases', component: DiseaseComponent},
  {path: 'testresultsoverview', component: TestresultOverviewComponent},
  {path: 'diseases/:id', component: ViewByIdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
