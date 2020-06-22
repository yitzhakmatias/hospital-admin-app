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
  isHospVisible: boolean;
  isSpecVisible: boolean;
  isDoctorVisible: boolean;
  hospitalId: any;

  constructor(private  hospitalServices: HospitalService) {
    this.isHospVisible = true;
    this.isSpecVisible = true;
    this.isDoctorVisible = true;
  }

  ngOnInit(): void {
    this.loadHospitals();
  }

  loadHospitals() {
    this.hospitalServices.getHospitals().then((resp) => {
      this.hospitals = resp;
    });
  }

  loadDependencies(event) {
    let target = event.currentTarget;
    this.hospitalId = target.attributes.id.value;
    this.hospitalServices.getDoctorsByHospital( this.hospitalId).then((res) => {
      this.doctors = res;
    });
    this.hospitalServices.getSpecialitiesByHospital( this.hospitalId).then(res => {
        this.specialities = res;
      }
    );
    this.hospitalServices.getPatientsByHospital( this.hospitalId).then(res => {
        this.patients = res;
      }
    );


  }

  editDoctor($event: MouseEvent) {

  }

  editSpeciality($event: MouseEvent) {

  }

  showHospitalForm() {
    this.isHospVisible = !this.isHospVisible;
    this.loadHospitals();
  }
  showSpecialityForm() {

    this.isSpecVisible = !this.isSpecVisible;
    this.loadHospitals();
  }
  showDoctorForm() {

    this.isDoctorVisible = !this.isDoctorVisible;
    this.loadHospitals();
  }
}
