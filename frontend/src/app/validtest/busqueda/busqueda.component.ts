import { Component, ElementRef, ViewChild } from '@angular/core';

import { ValidTestService } from '../services/validtest.service';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styles: [
  ]
})
export class BusquedaComponent {

  @ViewChild('txtBuscar') txtBuscar!:ElementRef<HTMLInputElement>;

  constructor( private validtestService: ValidTestService ) {}

  buscar() {
    
    const valor = this.txtBuscar.nativeElement.value;

    if ( valor.trim().length === 0 ) {
      return;
    }

    this.validtestService.buscar( valor );

    this.txtBuscar.nativeElement.value = '';
  }

}
