import { Component, Input } from '@angular/core';
import { Equipment } from './equipment';

@Component({
  selector: 'equipment-card',
  templateUrl: 'app/equipment/equipment-card.component.html'
})
export class EquipmentCardComponent {  
  @Input() equipment: Equipment;
  lastLocation: MovementRecord;
}
