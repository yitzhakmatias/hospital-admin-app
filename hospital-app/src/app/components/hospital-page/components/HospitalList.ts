import {Component, Input, OnInit} from '@angular/core';
import {HospitalService} from '../../../services/hospital.service';

@Component({
  selector: 'app-hospital-list',
  templateUrl: './hospitalList.html'
})
export class HospitalList implements OnInit {

  @Input()
  hospital: any;
  imageURL: any;

  constructor(private hospitalSrv: HospitalService) {
  }

  ngOnInit(): void {

    fetch('https://loremflickr.com/g/320/240/hospital').then(r => {
      this.imageURL = r.url;
    });
  }

}
