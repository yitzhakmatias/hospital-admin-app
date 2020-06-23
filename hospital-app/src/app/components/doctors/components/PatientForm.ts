import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HospitalService} from '../../../services/hospital.service';
import {Hospital} from '../../../Model/Hospital';
import {Patient} from '../../../Model/Patient';
import {PatientService} from '../../../services/PatientService';

@Component({
  selector: 'app-patient-form-component',
  templateUrl: './PatientForm.html'
})
export class PatientForm implements OnInit {

  patientForm: FormGroup;
  @Input()
  doctorId: any;
  submitted = false;
  @Output()
  onClose: EventEmitter<any> = new EventEmitter();
  patient: Patient;
  patientList: any;

  constructor(private formBuilder: FormBuilder, private hospitalSrv: HospitalService, private  patientServices: PatientService) {

  }

  ngOnInit(): void {
    this.patientForm = this.formBuilder.group({
      name: ['', Validators.required],
      patientId: ['', Validators.required],
      details: [''],
      photoURL: ['']
    });

    this.patientServices.getPatients().then((resp) => {
      this.patientList = resp;
    });
  }

  get f() {
    return this.patientForm.controls;
  }

  Save(event) {
    if (event.submitter.value === 'save'){
      this.patient = new Patient();
      this.patient.note = this.patientForm.get('details').value;

      this.patient.patientId = this.patientForm.get('patientId').value;
      this.patient.doctorId = this.doctorId;

      console.log(this.patient);
      this.patientServices.saveNotePatient(this.patient).then(response => {
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

  onOptionsSelected($event: Event) {

  }
}
