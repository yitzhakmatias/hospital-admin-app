import {Component, Input, OnInit} from '@angular/core';
import {PatientService} from '../../../services/PatientService';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './DoctorList.html'
})
export class DoctorList implements OnInit {

  @Input()
  doctor: any;
  imageURL: any;

  constructor(private patientSrv : PatientService) {
  }

  ngOnInit(): void {
    this.patientSrv.getImage().then(p => {
      this.imageURL = p.results[0].picture.large;
    }).catch(e => {
      this.imageURL = 'https://bulma.io/images/placeholders/128x128.png';
    });
  }

}
