import {Component, OnInit} from '@angular/core';
import {PatientService} from '../../services/PatientService';
import {DoctorServices} from '../../services/DoctorServices';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {


  patientList: any;
  doctorList: any;

  constructor(private  patientServices: PatientService, private  doctorSrv: DoctorServices) {
  }

  ngOnInit(): void {
    this.patientServices.getPatients().then((resp) => {
      this.patientList = resp;
      console.log(this.patientList);
    });
  }

  async onOptionsSelected($event) {
    if (this.patientList !== undefined) {

      console.log($event.target.value);
      var lst = this.patientList.find(p => p.PatientId === $event.target.value).notes;

      //if (notes)
      this.doctorList = await lst.map(p => {
        let doctor = this.getNameByDoctorId(p.DoctorId);
        return {...p, doctorName: doctor};
      });

    }
  }

  async getNameByDoctorId(DoctorId) {
    await this.doctorSrv.getDoctorById(DoctorId).then(x => {
      return x.name + '' + x.LastName;
    });
  }
}
