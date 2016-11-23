import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';

import { MovementRecord } from './movement-record';
import { Equipment } from '../equipment/equipment';

@Injectable()
export class MovementRecordService {

  constructor(
    private http: Http
  ) { }

  getLastMovementRecordOfEquipment(equipment: Equipment): Observable<MovementRecord> {
    return this.http
               .get('http://127.0.0.1:8000/movement-record?deviceId=' + equipment.deviceId)
               .map((r: Response) => r.json()[0] as MovementRecord || null);
  }
}
