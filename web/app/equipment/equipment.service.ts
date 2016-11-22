import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Equipment } from '../equipment/equipment';

@Injectable()
export class EquipmentService {
  constructor(private http: Http) { }

  searchForEquipment(searchTerm: string): Observable<Equipment[]> {
    return this.http
               .get('/equipment?search=' + searchTerm)
               .map((r: Response) => r.json().data as Equipment[]);
  }
}
