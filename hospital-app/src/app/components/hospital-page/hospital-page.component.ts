import {Component, OnInit} from '@angular/core';
import {HospitalService} from '../../services/hospital.service';

@Component({
  selector: 'app-hospital-page',
  templateUrl: './hospital-page.component.html',
  styleUrls: ['./hospital-page.component.css']
})
export class HospitalPageComponent implements OnInit {

  hospitals: any;

  constructor(private  hospitalServices: HospitalService) {
  }

  ngOnInit(): void {
    this.hospitalServices.getHospitals().then((resp) => {

      this.hospitals = resp;
      console.log(resp);
    });
  }

}
