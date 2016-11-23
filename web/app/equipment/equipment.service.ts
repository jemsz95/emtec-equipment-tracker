import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map'

import { Equipment } from '../equipment/equipment';

@Injectable()
export class EquipmentService {
  constructor(
    private http: Http
  ) { }

  searchForEquipment(searchTerm: string): Observable<Equipment[]> {
    return this.http
               .get('http://127.0.0.1:8000/equipment?q=' + searchTerm)
               .map((r: Response) => r.json() as Equipment[]);
  }
}
