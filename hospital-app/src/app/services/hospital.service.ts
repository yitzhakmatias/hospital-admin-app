import {Injectable} from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {
  baseUrl = 'http://localhost:8082/api/v1/hospital/';

  constructor() {
  }

  getHospitals() {
    return axios.get(this.baseUrl + '/collections').then((response) => {
      console.log(response);
      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }

  getDoctorsByHospital(uuid) {
    return axios.get(this.baseUrl + '/doctors/' + uuid).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
  getSpecialitiesByHospital(uuid) {
    return axios.get(this.baseUrl + '/specialities/' + uuid).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
  getPatientsByHospital(uuid) {
    return axios.get(this.baseUrl + '/patients/' + uuid).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
}
