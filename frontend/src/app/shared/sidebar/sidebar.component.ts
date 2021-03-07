import { Component } from '@angular/core';
import { ValidTestService } from '../../validTes/services/validTest.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styles: [
  ]
})
export class SidebarComponent {

  get historial() {
    return this.validtestService.historial;
  }

  constructor( private validtestService: ValidTestService  ) { }

  buscar( termino: string ) {
    this.validtestService.buscar( termino );
  }
}
