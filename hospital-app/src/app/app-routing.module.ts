import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PatientComponent} from './components/patient/patient.component';
import {SpecialtiesComponent} from './components/specialties/specialties.component';
import {DoctorsComponent} from './components/doctors/doctors.component';
import {HospitalPageComponent} from './components/hospital-page/hospital-page.component';


const routes: Routes = [
  {path: 'patient-component', component: PatientComponent},
  {path: 'specialties-component', component: SpecialtiesComponent},
  {path: 'doctors-component', component: DoctorsComponent},
  {path: 'hospitals', component: HospitalPageComponent},
  {path: '', redirectTo: '/', pathMatch: 'full'}, // redirect to `first-component`
  {path: '**', component: HospitalPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
