import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Equipment } from './equipment';
import { MovementRecord } from '../movement-record/movement-record';
import { MovementRecordService } from '../movement-record/movement-record.service'

@Component({
  selector: 'equipment-card',
  templateUrl: 'app/equipment/equipment-card.component.html',
  styles: [
    ':host { display: flex; margin: 8px; }'
  ]
})
export class EquipmentCardComponent implements OnInit {  
  @Input() equipment: Equipment;
  
  lastMovement: MovementRecord;
                                     
  constructor(
    private movementRecordService: MovementRecordService
  ) { }

  ngOnInit() {
    this.movementRecordService
        .getLastMovementRecordOfEquipment(this.equipment)
        .subscribe(
          value => this.lastMovement = value,
          error => console.error(error),
        );
  }
}
