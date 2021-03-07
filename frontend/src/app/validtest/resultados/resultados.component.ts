import { Component } from '@angular/core';
import { ValidTestService } from '../services/validtest.service';

@Component({
  selector: 'app-resultados',
  templateUrl: './resultados.component.html',
  styles: [
  ]
})
export class ResultadosComponent {

  get resultados() {
    return this.ValidTestService.resultados;
  }

  constructor( private validtestService: ValidTestService ) { }


}
