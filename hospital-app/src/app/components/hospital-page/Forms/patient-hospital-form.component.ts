import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HospitalService} from '../../../services/hospital.service';
import {Hospital} from '../../../Model/Hospital';
import {Speciality} from '../../../Model/Speciality';
import {SpecialityService} from '../../../services/speciality.service';
import {Doctor} from '../../../Model/Doctor';
import {DoctorServices} from '../../../services/DoctorServices';
import {Patient} from '../../../Model/Patient';
import {PatientService} from '../../../services/PatientService';

@Component({
  selector: 'app-patient-hospital-form',
  templateUrl: './patient-hospital-form.component.html'
})
export class PatientHospitalForm implements OnInit {

  patientHospForm: FormGroup;
  submitted = false;
  @Output()
  onClose: EventEmitter<any> = new EventEmitter();
  patient: Doctor;
  @Input()
  hospitalUUID: any;

  constructor(private formBuilder: FormBuilder, private patientSrv: PatientService) {
  }

  ngOnInit(): void {
    this.patientHospForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      photoURL: ['']
    });
  }

  get f() {
    return this.patientHospForm.controls;
  }

  Save(event: any) {
    if (event.submitter.value === 'save') {
      let name = this.patientHospForm.get('name').value;
      let lastName = this.patientHospForm.get('lastName').value;
      this.patient = new Patient();
      this.patient.name = name;
      this.patient.lastName = lastName;
      this.patient.address = this.patientHospForm.get('address').value;

      this.patient.hospitalId = this.hospitalUUID;

      this.patientSrv.savePatient(this.patient).then(response => {
        let resp = response;
        this.close();
      }).catch(e => {
        console.log(e);
      });
    }
  }

  close() {
    this.onClose.emit(null);
  }
}
