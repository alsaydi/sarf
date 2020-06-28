import { Component, OnInit, Input } from '@angular/core';
import { Conjugationclass } from '../models/conjugationclass';

@Component({
  selector: 'app-conjugation-group',
  templateUrl: './conjugation-group.component.html',
  styleUrls: ['./conjugation-group.component.css']
})
export class ConjugationGroupComponent implements OnInit {

  @Input() public conjugationClasses: Conjugationclass[];

  constructor() { }

  ngOnInit(): void {
  }

}
