import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientComponent } from './components/patient/patient.component';
import { SpecialtiesComponent } from './components/specialties/specialties.component';
import { DoctorsComponent } from './components/doctors/doctors.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    SpecialtiesComponent,
    DoctorsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
