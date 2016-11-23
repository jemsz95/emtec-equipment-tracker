import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipment } from './equipment';
import { MovementRecord } from '../movement-record/movement-record';
import { MovementRecordService } from '../movement-record/movement-record.service'

@Component({
  selector: 'equipment-card',
  templateUrl: 'app/equipment/equipment-card.component.html'
})
export class EquipmentCardComponent implements OnInit {  
  @Input() equipment: Equipment;
  
  location: MovementRecord = null;
                                     
  constructor(
    private movementRecordService: MovementRecordService
  ) { }

  ngOnInit() {
    console.log(this.equipment);
    /*this.movementRecordService
        .getLastRecordOfEquipment(this.equipment)
        .subscribe(
          value => this.location = value[0] || null,
          error => console.error("lastLocationSubscription: Error"),
        );*/
  }
}
