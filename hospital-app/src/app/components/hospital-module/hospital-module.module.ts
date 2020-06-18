import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PatientComponent} from '../patient/patient.component';
import {PatientForm} from '../patient/components/patient-form';



@NgModule({
  declarations: [
    PatientForm
  ],
  imports: [
    CommonModule
  ]
})
export class HospitalModuleModule { }
