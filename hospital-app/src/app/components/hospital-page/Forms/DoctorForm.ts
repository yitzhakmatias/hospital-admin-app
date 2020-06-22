import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HospitalService} from '../../../services/hospital.service';
import {Hospital} from '../../../Model/Hospital';
import {Speciality} from '../../../Model/Speciality';
import {SpecialityService} from '../../../services/speciality.service';
import {Doctor} from '../../../Model/Doctor';
import {DoctorServices} from '../../../services/DoctorServices';

@Component({
  selector: 'app-doctor-form',
  templateUrl: './DoctorForm.html'
})
export class DoctorForm implements OnInit {

  DoctorForm: FormGroup;
  submitted = false;
  @Output()
  onClose: EventEmitter<any> = new EventEmitter();
  doctor: Doctor;
  @Input()
  hospitalUUID: any;

  constructor(private formBuilder: FormBuilder, private doctorSrv: DoctorServices) {

  }

  ngOnInit(): void {
    this.DoctorForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      photoURL: ['']
    });
  }

  get f() {
    return this.DoctorForm.controls;
  }

  Save(event: any) {
    if (event.submitter.value === 'save') {
      let name = this.DoctorForm.get('name').value;
      let lastName = this.DoctorForm.get('lastName').value;
      this.doctor = new Doctor();
      this.doctor.name = name;
      this.doctor.lastName = lastName;
      this.doctor.address = this.DoctorForm.get('address').value;

      this.doctor.hospitalId = this.hospitalUUID;

      this.doctorSrv.saveDoctor(this.doctor).then(response => {
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
