import {Component, OnInit} from '@angular/core';
import {HospitalService} from '../../services/hospital.service';
import {PatientService} from '../../services/PatientService';
import {DoctorServices} from '../../services/DoctorServices';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  patientList: any;
  doctorList: any;

  constructor(private  patientServices: PatientService, private  doctorService: DoctorServices) {
  }

  ngOnInit(): void {
    this.doctorService.getDoctors().then((resp) => {

      this.doctorList = resp;
      // this.patientList= resp.patients;
    });


    console.log('asdfasdfas');
  }

  onOptionsSelected(item): void {
    if (this.doctorList !== undefined) {
      var list = this.doctorList.filter(p => p.DoctorId === item.target.value);
      console.log(list);
      this.patientList = list[0].patients;
    }
  }
}
