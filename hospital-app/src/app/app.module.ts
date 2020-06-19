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
import {StoreModule} from '@ngrx/store';
import {reducers, metaReducers} from './reducers';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';
import {environment} from '../environments/environment';
import {PatientItemComponent} from './components/doctors/components/PatientItemComponent';
import {DoctorItemComponent} from './components/patient/components/doctorItem.component';




@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    SpecialtiesComponent,
    DoctorsComponent,
    HospitalPageComponent,
    HospitalList,
    PatientForm,
    PatientItemComponent,
    DoctorItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    StoreModule.forRoot(reducers, {
      metaReducers,
      runtimeChecks: {
        strictStateImmutability: true,
        strictActionImmutability: true,
      }
    }),
    !environment.production ? StoreDevtoolsModule.instrument() : [],

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
