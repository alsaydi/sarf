import { Component, OnInit, Input } from '@angular/core';
import { QuadConjugationGroup } from '../models/quad-conjugation-group';

@Component({
  selector: 'app-quadilateral-conjugation-panel',
  templateUrl: './quadilateral-conjugation-panel.component.html',
  styleUrls: ['./quadilateral-conjugation-panel.component.css']
})
export class QuadilateralConjugationPanelComponent implements OnInit {
  @Input() conjugationGroup: QuadConjugationGroup;

  constructor() { }

  ngOnInit(): void {
  }
}
