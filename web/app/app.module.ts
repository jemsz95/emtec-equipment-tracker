import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppRouterModule } from './app-router.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav.component';
import { EquipmentSearchComponent } from './equipment/equipment-search.component';
import { EquipmentCardComponent } from './equipment/equipment-card.component';
import { EquipmentService } from './equipment/equipment.service';
import { MovementRecordService } from './movement-record/movement-record.service';


@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRouterModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    EquipmentSearchComponent,
    EquipmentCardComponent
  ],
  bootstrap: [
    AppComponent
  ],
  providers: [
    EquipmentService,
    MovementRecordService
  ]
})
export class AppModule { }

