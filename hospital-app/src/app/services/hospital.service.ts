import { Injectable } from '@angular/core';
import axios from 'axios';
@Injectable({
  providedIn: 'root'
})
export class HospitalService {
  baseUrl = 'http://localhost:8082/api/v1/hospital/collections';
  constructor() { }

  getHospitals(){
    return axios.get(this.baseUrl ).then((response) => {
      console.log(response);
      return response.data;

    }).catch((error) => {
      console.log(error);
    });
  }
}
