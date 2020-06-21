import {Component, Input, OnInit} from '@angular/core';
import {PatientService} from '../../../services/PatientService';

@Component({
  selector: 'app-patient-item',
  templateUrl: './PatientComponent.html'
})
export class PatientItemComponent implements OnInit {
  @Input()
  patient: any;
  image: any;

  constructor(private patientService: PatientService) {

  }

  ngOnInit(): void {
    this.patientService.getImage().then(p => {
      this.image = p.results[0].picture.large;
    }).catch(e => {
      this.image = 'https://bulma.io/images/placeholders/128x128.png';
    });

  }
}
