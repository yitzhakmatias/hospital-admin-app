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
  doctorCollection: any;

  constructor(private  patientServices: PatientService, private  doctorSrv: DoctorServices) {
  }

  ngOnInit(): void {
    this.doctorSrv.getDoctors().then(resp => {
      this.doctorList = resp;
    }).then(() => {
        this.patientServices.getPatients().then((resp) => {
          this.patientList = resp;
          console.log(this.patientList);
        });
      }
    );


  }

  async onOptionsSelected($event) {
    if (this.patientList !== undefined) {

      console.log($event.target.value);
      var lst = this.patientList.find(p => p.PatientId === $event.target.value).notes;

      //if (notes)
      this.doctorCollection = await lst.map(p => {

        let doctor = this.doctorList.find(x => {
            return x.DoctorId === p.DoctorId;
          }
        );
        console.log(doctor);
        if (doctor !== undefined) {
          return {...p, doctorName: doctor.name + ' ' + doctor.lastName};
        } else {
          return p;
        }

      });

    }
  }

  async getNameByDoctorId(DoctorId) {

    return await this.doctorSrv.getDoctorById(DoctorId).then(x => {
      return x.name + '' + x.LastName;
    });
  }
}
