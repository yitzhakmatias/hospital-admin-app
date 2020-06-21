import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PatientComponent} from '../patient/patient.component';
import {PatientForm} from '../patient/components/patient-form';
import {DoctorList} from './components/DoctorList';
import {PatientList} from './components/PatientList';
import {SpecialityList} from './components/SpecialityList';



@NgModule({
  declarations: [
    DoctorList,
    PatientList,
    SpecialityList
  ],
  exports: [
    DoctorList,
    SpecialityList,
    PatientList
  ],
  imports: [
    CommonModule
  ]
})
export class HospitalModule { }
