import { Component, OnInit, Input } from '@angular/core';
import { ConjugationClass } from '../models/conjugationclass';

@Component({
  selector: 'app-conjugation-group',
  templateUrl: './conjugation-group.component.html',
  styleUrls: ['./conjugation-group.component.css']
})
export class ConjugationGroupComponent implements OnInit {

  @Input() public conjugationClasses: ConjugationClass[];

  constructor() { }

  ngOnInit(): void {
  }

}
