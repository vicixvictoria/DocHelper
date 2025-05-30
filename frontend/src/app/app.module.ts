import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatButtonModule} from '@angular/material/button';
import { PatientComponent } from './patient/patient.component';
import {MatTableModule} from "@angular/material/table";
import {HttpClientModule} from "@angular/common/http";
import { AddPatientComponent } from './patient/add-patient/add-patient.component';
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatCheckboxModule} from "@angular/material/checkbox";
import { EditPatientComponent } from './patient/edit-patient/edit-patient.component';
import { TestresultOverviewComponent } from './testresult/testresult-overview/testresult-overview.component';
import {MatDividerModule} from '@angular/material/divider';
import { TestresultDetailComponent } from './testresult/testresult-detail/testresult-detail.component';
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import { DiseaseComponent } from './disease/disease.component';
import {MatStepperModule} from '@angular/material/stepper';
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from "@angular/material/radio";
import {AddTestResultComponent} from "./testresult/add-test result/add-testresult.component";
import {AddLabMeasureComponent} from "./testresult/add-labmeasure/add-labmeasure.component";
import {AddLabValueComponent} from "./lab-value/add-lab-value/add-lab-value.component";
import {LabValueComponent} from "./lab-value/lab-value.component";
import {EditTestResultComponent} from "./testresult/edit-test result/edit-testresult.component";
import {ViewDiseaseComponent} from "./disease/view-disease/view-disease.component";
import {ViewByIdComponent} from "./disease/view-disease/view-by-id/view-by-id.component";
import {AddDiseaseComponent} from "./disease/add-disease/add-disease.component";
import {AnalysisComponent} from "./analysis/analysis.component";
import {Category} from "../global/category";
import {
  IgxDataChartCoreModule,
  IgxDataChartVerticalCategoryModule,
  IgxLegendModule,
  IgxDataChartInteractivityModule
} from "igniteui-angular-charts";
import {NgChartsModule} from 'ng2-charts';
import {NgApexchartsModule} from "ng-apexcharts";


// @ts-ignore
// @ts-ignore
@NgModule({
  declarations: [
    LabValueComponent,
    AddLabValueComponent,
    AppComponent,
    HomeComponent,
    HeaderComponent,
    PatientComponent,
    AddPatientComponent,
    EditPatientComponent,
    TestresultOverviewComponent,
    TestresultDetailComponent,
    DiseaseComponent,
    AddTestResultComponent,
    AddLabMeasureComponent,
    EditTestResultComponent,
    ViewDiseaseComponent,
    ViewByIdComponent,
    AddDiseaseComponent,
    AnalysisComponent
  ],
  imports: [
    MatSelectModule,
    MatStepperModule,
    MatGridListModule,
    MatCardModule,
    MatDividerModule,
    MatNativeDateModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatDialogModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonToggleModule,
    MatButtonModule,
    MatTableModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatListModule,
    MatAutocompleteModule,
    MatRadioModule,
    IgxDataChartCoreModule,
    IgxDataChartVerticalCategoryModule,
    IgxLegendModule,
    IgxDataChartInteractivityModule,
    NgChartsModule,
    NgApexchartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
