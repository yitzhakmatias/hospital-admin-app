import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DoctorList} from './components/DoctorList';
import {PatientList} from './components/PatientList';
import {SpecialityList} from './components/SpecialityList';
import {HospitalForm} from './Forms/HospitalForm';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SpecialityForm} from './Forms/SpecialityForm';
import {DoctorForm} from './Forms/DoctorForm';
import {PatientHospitalForm} from './Forms/patient-hospital-form.component';


@NgModule({
  declarations: [
    DoctorList,
    PatientList,
    SpecialityList,
    HospitalForm,
    SpecialityForm,
    DoctorForm,
    PatientHospitalForm
  ],
  exports: [
    DoctorList,
    SpecialityList,
    PatientList,
    HospitalForm,
    SpecialityForm,
    DoctorForm,
    PatientHospitalForm
  ],
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule
  ]
})
export class HospitalModule {
}
