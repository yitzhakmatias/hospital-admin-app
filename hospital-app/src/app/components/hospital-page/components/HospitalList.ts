import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-hospital-list',
  templateUrl: './hospitalList.html'
})
export class HospitalList implements OnInit {

  @Input()
  hospital: any;

  constructor() {
  }

  ngOnInit(): void {

  }

}
