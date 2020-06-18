import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalPageComponent } from './hospital-page.component';

describe('HospitalPageComponent', () => {
  let component: HospitalPageComponent;
  let fixture: ComponentFixture<HospitalPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HospitalPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
