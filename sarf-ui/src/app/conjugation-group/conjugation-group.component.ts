import { Component, OnInit, Input } from '@angular/core';
import { ConjugationGroup } from '../models/conjugationgroup';

@Component({
  selector: 'app-conjugation-group',
  templateUrl: './conjugation-group.component.html',
  styleUrls: ['./conjugation-group.component.css']
})
export class ConjugationGroupComponent implements OnInit {

  @Input() public conjugationGroup: ConjugationGroup;

  constructor() { }

  ngOnInit(): void {
  }

}
