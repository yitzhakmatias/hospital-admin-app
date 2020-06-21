import {Component, OnInit} from '@angular/core';
import {HospitalService} from '../../services/hospital.service';

@Component({
  selector: 'app-hospital-page',
  templateUrl: './hospital-page.component.html',
  styleUrls: ['./hospital-page.component.css']
})
export class HospitalPageComponent implements OnInit {

  hospitals: any;
  doctors: any;
  specialities: any;
  patients: any;
  isHospVisible:boolean;
  constructor(private  hospitalServices: HospitalService) {
    this.isHospVisible=true;
  }

  ngOnInit(): void {
    this.hospitalServices.getHospitals().then((resp) => {
      this.hospitals = resp;
    });
  }

  loadDependencies(event) {
    var target = event.currentTarget;
    var idAttr = target.attributes.id.value;
    this.hospitalServices.getDoctorsByHospital(idAttr).then((res) => {
      this.doctors = res;
    });
    this.hospitalServices.getSpecialitiesByHospital(idAttr).then(res => {
        this.specialities = res;
      }
    );
    this.hospitalServices.getPatientsByHospital(idAttr).then(res => {
        this.patients = res;
      }
    );


  }

  editDoctor($event: MouseEvent) {

  }

  editSpeciality($event: MouseEvent) {

  }

  showHospitalForm() {
    this.isHospVisible=!this.isHospVisible;
  }
}
