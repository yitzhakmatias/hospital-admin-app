import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-speciality-list',
  templateUrl: './SpecialityList.html'
})
export class SpecialityList implements OnInit {

  @Input()
  speciality: any;
  imageUrl:any
  constructor() {
  }

  ngOnInit(): void {

  }

}
