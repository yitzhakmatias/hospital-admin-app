import {Component, OnInit} from '@angular/core';
import {HospitalService} from '../../services/hospital.service';
import {PatientService} from '../../services/PatientService';
import {DoctorServices} from '../../services/DoctorServices';

@Component({
  selector: 'app-doctors-display',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  patientList: any;
  doctorList: any;
  isPatientFormHidden: any;
  doctorId: any;

  constructor(private  patientServices: PatientService, private  doctorService: DoctorServices) {
    this.isPatientFormHidden = true;
  }

  ngOnInit(): void {
    this.loadDoctors().then(() => {
    });
  }

  async loadDoctors() {
    await this.doctorService.getDoctors().then((resp) => {

      this.doctorList = resp;

    });
  }

  onOptionsSelected(item): void {
    if (this.doctorList !== undefined) {
      this.doctorId = item.target.value;
      this.loadPatients(this.doctorId);
    }
  }

  loadPatients(doctorId) {
    let list = this.doctorList.filter(p => p.DoctorId === doctorId);

    this.patientList = list[0].patients;
  }

  showPatientForm() {
    this.isPatientFormHidden = !this.isPatientFormHidden;
    this.loadDoctors().then(() => {
      this.loadPatients(this.doctorId);
    });

  }
}
