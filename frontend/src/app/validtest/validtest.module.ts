import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ValidTestPageComponent } from './validtest-page/validtest-page.component';
import { BusquedaComponent } from './busqueda/busqueda.component';
import { ResultadosComponent } from './resultados/resultados.component';
import { RegistroComponent } from './registro/registro.component';


@NgModule({
  declarations: [
    ValidTestPageComponent,
    BusquedaComponent,
    ResultadosComponent,
	RegistroComponent
  ],
  exports: [
    ValidTestPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ValidTestModule { }
