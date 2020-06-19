import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-doctor-item',
  templateUrl: './doctorItem.html',

})
export class DoctorItemComponent implements OnInit {
  @Input()
  doctor:any;
  image:any;
  constructor() { }

  ngOnInit(): void {
  }

}
