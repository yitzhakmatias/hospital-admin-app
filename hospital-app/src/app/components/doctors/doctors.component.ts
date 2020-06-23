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
    this.doctorService.getDoctors().then((resp) => {

      this.doctorList = resp;

    });

  }

  onOptionsSelected(item): void {
    if (this.doctorList !== undefined) {
      this.doctorId = item.target.value;
      let list = this.doctorList.filter(p => p.DoctorId === item.target.value);
      console.log(list);

      this.patientList = list[0].patients;
    }
  }

  showPatientForm() {
    this.isPatientFormHidden = !this.isPatientFormHidden;
  }
}
