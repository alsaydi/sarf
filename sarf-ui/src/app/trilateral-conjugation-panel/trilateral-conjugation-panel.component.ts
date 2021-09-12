import { Component, OnInit, Input } from '@angular/core';
import { TrilateralConjugationGroup } from '../models/trilateral-conjugation-group';
import { ConjugationGroup } from '../models/conjugationgroup';
import { ConjugationClass } from '../models/conjugationclass';

@Component({
  selector: 'app-trilateral-conjugation-panel',
  templateUrl: './trilateral-conjugation-panel.component.html',
  styleUrls: ['./trilateral-conjugation-panel.component.css']
})
export class TrilateralConjugationPanelComponent implements OnInit {
  @Input() conjugationGroup: TrilateralConjugationGroup;

  constructor() { }

  ngOnInit(): void {
  }  
}
