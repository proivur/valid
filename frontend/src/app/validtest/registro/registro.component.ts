import { Component, ElementRef, ViewChild } from '@angular/core';

import { ValidTestService } from '../services/validtest.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styles: [
  ]
})
export class BusquedaComponent {

  @ViewChild('txtFirstName') txtFirstName!:ElementRef<HTMLInputElement>;
  @ViewChild('txtLastName') txtLastName!:ElementRef<HTMLInputElement>;
  @ViewChild('txtStatus') txtStatus!:ElementRef<HTMLInputElement>;
  @ViewChild('txtRegistrar') txtRegistrar!:ElementRef<HTMLInputElement>;


  constructor( private validtestService: ValidTestService ) {}

  registrar() {
    
    const firstName = this.txtBuscar.nativeElement.value;
	const lastName = this.txtBuscar.nativeElement.value;
	const status = this.txtBuscar.nativeElement.value;


    this.validtestService.registrar( firstName, lastName, status);

    this.txtBuscar.nativeElement.value = '';
	this.txtLastName.nativeElement.value = '';
	this.txtStatus.nativeElement.value = '';
	this.txtRegistrar.nativeElement.value = '';
  }

}
