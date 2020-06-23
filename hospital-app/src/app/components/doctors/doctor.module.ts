import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {PatientForm} from './components/PatientForm';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    PatientForm
  ],
  exports: [
    PatientForm
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class DoctorModule {
}
