import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HospitalService} from '../../../services/hospital.service';
import {Hospital} from '../../../Model/Hospital';
import {Speciality} from '../../../Model/Speciality';
import {SpecialityService} from '../../../services/speciality.service';

@Component({
  selector: 'app-speciality-form',
  templateUrl: './SpecialityForm.html'
})
export class SpecialityForm implements OnInit {

  SpecialityForm: FormGroup;
  submitted = false;
  @Output()
  onCloseSpeciality: EventEmitter<any> = new EventEmitter();
  speciality: Speciality;
  @Input()
  hospitalUUID: any;

  constructor(private formBuilder: FormBuilder, private specialitySrv: SpecialityService) {

  }

  ngOnInit(): void {
    this.SpecialityForm = this.formBuilder.group({
      name: ['', Validators.required],
      details: [''],
      photoURL: ['']
    });
  }

  get f() {
    return this.SpecialityForm.controls;
  }

  Save(event: any) {
    if (event.submitter.value === 'save') {
      let name = this.SpecialityForm.get('name').value;
      let details = this.SpecialityForm.get('details').value;
      this.speciality = new Speciality();
      this.speciality.name = name;
      this.speciality.description = details;
      this.speciality.hospitalId = this.hospitalUUID;

      this.specialitySrv.saveSpeciality(this.speciality).then(response => {
        let resp = response;
        this.close();
      }).catch(e => {
        console.log(e);
      });
    }
  }

  close() {
    this.onCloseSpeciality.emit(null);
  }
}
