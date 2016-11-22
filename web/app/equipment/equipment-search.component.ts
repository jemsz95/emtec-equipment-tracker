import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Equipment } from './equipment';
import { EquipmentService } from './equipment.service';

@Component({
  selector: 'equipment-search',
  templateUrl: 'app/equipment/equipment-search.component.html'
})
export class EquipmentSearchComponent {
  equipmentList : Equipment[];
  searchTerms = new FormControl();

  constructor(
    private equipmentService : EquipmentService
  ) { }
}
