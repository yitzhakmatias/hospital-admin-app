import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-hospital-form',
  templateUrl: './HospitalForm.html'
})
export class HospitalForm implements OnInit {

  hospitalForm: FormGroup;
  submitted = false;
  @Output()
  change: EventEmitter<any> = new EventEmitter();


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.hospitalForm = this.formBuilder.group({
      name: ['', Validators.required],
      photoURL: ['']
    });
  }

  get f() {
    return this.hospitalForm.controls;
  }

  Save() {

  }

  close() {
    this.change.emit(null);
  }
}
