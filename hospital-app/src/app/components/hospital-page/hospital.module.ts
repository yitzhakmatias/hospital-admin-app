import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PatientComponent} from '../patient/patient.component';
import {PatientForm} from '../patient/components/patient-form';
import {DoctorList} from './components/DoctorList';
import {PatientList} from './components/PatientList';
import {SpecialityList} from './components/SpecialityList';
import {HospitalForm} from './Forms/HospitalForm';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SpecialityForm} from './Forms/SpecialityForm';
import {DoctorForm} from './Forms/DoctorForm';


@NgModule({
  declarations: [
    DoctorList,
    PatientList,
    SpecialityList,
    HospitalForm,
    SpecialityForm,
    DoctorForm
  ],
  exports: [
    DoctorList,
    SpecialityList,
    PatientList,
    HospitalForm,
    SpecialityForm,
    DoctorForm
  ],
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule
  ]
})
export class HospitalModule {
}
