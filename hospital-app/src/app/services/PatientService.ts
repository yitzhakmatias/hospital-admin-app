import { Injectable } from '@angular/core';
import axios from 'axios';
@Injectable({
  providedIn: 'root'
})
export class PatientService {
  baseUrl = 'http://localhost:8082/api/v1/patient/collections';
  constructor() { }

  getPatients(){
    return axios.get(this.baseUrl ).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
  getImage(){
    return axios.get("https://randomuser.me/api/?gender=male" ).then((response) => {

      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
}