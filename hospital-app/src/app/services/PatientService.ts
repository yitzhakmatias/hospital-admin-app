import {Injectable} from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  baseUrl = 'http://localhost:8082/api/v1/patient';

  constructor() {
  }

  getPatients() {
    return axios.get(this.baseUrl + '/collections').then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }

  getImage() {
    return axios.get('https://randomuser.me/api/?gender=male').then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }

  savePatient(model): any {

    return axios.post(this.baseUrl + '/add', model).then((response) => {
      console.log(response);
    }).catch((error) => {
      console.log(error);
    });
  }

  saveNotePatient(model): any {
    return axios.post(this.baseUrl + '/addnote', model).then((response) => {
      console.log(response);
    }).catch((error) => {
      console.log(error);
    });
  }

}
