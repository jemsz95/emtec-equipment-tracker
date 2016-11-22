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
  location: MovementRecord;
  timeFromLastLocationTime: string;
                                     
  constructor(private movementRecordService: MovementRecordService) {  }

  ngOnInit() {
    this.movementRecordService
        .getLastRecordOfEquipment(this.equipment)
        .subscribe(
          value => this.location = value[0] || null,
          error => console.error("lastLocationSubscription: Error"),
        );
  }
}
