import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HospitalService} from '../../../services/hospital.service';
import {Hospital} from '../../../Model/Hospital';

@Component({
  selector: 'app-hospital-form',
  templateUrl: './HospitalForm.html'
})
export class HospitalForm implements OnInit {

  hospitalForm: FormGroup;
  submitted = false;
  @Output()
  onClose: EventEmitter<any> = new EventEmitter();
  hospital: Hospital;

  constructor(private formBuilder: FormBuilder, private hospitalSrv: HospitalService) {
    console.log('asdfasdfasdfsadfsad');
  }

  ngOnInit(): void {
    this.hospitalForm = this.formBuilder.group({
      name: ['', Validators.required],
      details: [''],
      photoURL: ['']
    });
  }

  get f() {
    return this.hospitalForm.controls;
  }

  Save() {
    let name = this.hospitalForm.get('name').value;
    let details = this.hospitalForm.get('details').value;
    this.hospital = new Hospital();
    this.hospital.name = name;
    this.hospital.details = details;

    this.hospitalSrv.saveHospital( this.hospital).then(response => {
      let resp = response;
      //this.getPurchaseList();
    }).catch(e => {
      console.log(e);
    });
  }

  close() {
    this.onClose.emit(null);
  }
}
