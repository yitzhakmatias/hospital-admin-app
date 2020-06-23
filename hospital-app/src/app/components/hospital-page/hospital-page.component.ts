import {Component, OnInit} from '@angular/core';
import {HospitalService} from '../../services/hospital.service';

@Component({
  selector: 'app-hospital-page',
  templateUrl: './hospital-page.component.html',
  styleUrls: ['./hospital-page.component.css']
})
export class HospitalPageComponent implements OnInit {

  hospitals: any;
  hospitalsOld: any;
  doctors: any;
  specialities: any;
  patients: any;
  isHospVisible: boolean;
  isSpecVisible: boolean;
  isPatVisible: boolean;
  isDoctorVisible: boolean;
  hospitalId: any;
  search: any;

  constructor(private  hospitalServices: HospitalService) {
    this.isHospVisible = true;
    this.isSpecVisible = true;
    this.isDoctorVisible = true;
    this.isPatVisible = true;
  }

  ngOnInit(): void {
    this.loadHospitals();
  }

  loadHospitals() {
    this.hospitalServices.getHospitals().then((resp) => {
      this.hospitals = resp;
      this.hospitalsOld = this.hospitals;
    });
  }

  loadDependencies(event) {
    let target = event.currentTarget;
    this.hospitalId = target.attributes.id.value;
    this.hospitalServices.getDoctorsByHospital(this.hospitalId).then((res) => {
      this.doctors = res;
    });
    this.hospitalServices.getSpecialitiesByHospital(this.hospitalId).then(res => {
        this.specialities = res;
      }
    );
    this.hospitalServices.getPatientsByHospital(this.hospitalId).then(res => {
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

  showPatientForm() {

    this.isPatVisible = !this.isPatVisible;
    this.loadHospitals();
  }

  isHidden() {
    return this.hospitalId === undefined;
  }

  updateHospitalList($event) {
    let search = $event;

    if (search.length >= 3) {
      this.hospitals = this.hospitals.filter(p => {
        return p.name.includes(search);
      });
    } else {
      this.hospitals = this.hospitalsOld;
    }

  }

  resetFilter() {
    this.hospitals = this.hospitalsOld;
    this.search="";
  }
}
