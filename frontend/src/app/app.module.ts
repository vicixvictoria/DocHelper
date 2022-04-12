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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    PatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonToggleModule,
    MatButtonModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
