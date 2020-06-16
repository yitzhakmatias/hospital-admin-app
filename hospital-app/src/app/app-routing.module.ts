import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PatientComponent} from './components/patient/patient.component';
import {SpecialtiesComponent} from './components/specialties/specialties.component';
import {DoctorsComponent} from './components/doctors/doctors.component';


const routes: Routes = [
  {path: 'patient-component', component: PatientComponent},
  {path: 'specialties-component', component: SpecialtiesComponent},
  {path: 'doctors-component', component: DoctorsComponent},
  { path: '',   redirectTo: '/', pathMatch: 'full' }, // redirect to `first-component`
  { path: '**', component: PatientComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
