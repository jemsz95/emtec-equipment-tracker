import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { MovementRecord } from './movement-record';
import { Equipment } from '../equipment/equipment';

@Injectable()
export class MovementRecordService {

  constructor(
    private http: Http
  ) { }

  getLastRecordOfEquipment(equipment: Equipment): Observable<MovementRecord[]> {
    return this.http
               .get('/movement-record?idEquipment=' + equipment.id)
               .map((r: Response) => r.json().data as MovementRecord[]);
  }
}
