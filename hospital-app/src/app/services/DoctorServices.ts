import {Injectable} from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class DoctorServices {
  baseUrl = 'http://localhost:8082/api/v1/doctor/';

  constructor() {
  }

  getDoctors() {
    return axios.get(this.baseUrl + 'collections').then((response) => {
      console.log(response);
      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }

  getDoctorById(id) {
    let doctor = axios.get(this.baseUrl + id).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
    return doctor;
  }
}
