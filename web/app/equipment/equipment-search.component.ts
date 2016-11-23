import { Component } from '@angular/core';
import { Equipment } from './equipment';
import { EquipmentService } from './equipment.service';

@Component({
  selector: 'equipment-search',
  templateUrl: 'app/equipment/equipment-search.component.html'
})
export class EquipmentSearchComponent {
  equipmentList : Equipment[];
  searchText : string;

  constructor(
    private equipmentService : EquipmentService
  ) { }

  search() {
    this.equipmentService
        .searchForEquipment(this.searchText)
        .subscribe(
          (data) => {this.equipmentList = data; console.log(data); },
          (error) => console.error(error)
        );

    ;
  }
}
