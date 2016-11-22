import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRouterModule } from './app-router.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav.component';
import { EquipmentSearchComponent } from './equipment/equipment-search.component';


@NgModule({
  imports: [
    BrowserModule,
    AppRouterModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    EquipmentSearchComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }

