import {Injectable} from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class SpecialityService {
  baseUrl = 'http://localhost:8082/api/v1/speciality/';

  constructor() {
  }

  saveSpeciality(model): any {
    return axios.post(this.baseUrl + '/add', model).then((response) => {
      console.log(response);
    }).catch((error) => {
      console.log(error);
    });
  }
}
