import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PatientComponent} from './components/patient/patient.component';
import {SpecialtiesComponent} from './components/specialties/specialties.component';
import {DoctorsComponent} from './components/doctors/doctors.component';
import {HospitalPageComponent} from './components/hospital-page/hospital-page.component';
import {HospitalList} from './components/hospital-page/components/HospitalList';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {PatientForm} from './components/patient/components/patient-form';


@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    SpecialtiesComponent,
    DoctorsComponent,
    HospitalPageComponent,
    HospitalList,
    PatientForm
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
