import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipmentSearchComponent } from './equipment/equipment-search.component';

const appRoutes: Routes = [
  { path: '', component: EquipmentSearchComponent }
]

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRouterModule {}
