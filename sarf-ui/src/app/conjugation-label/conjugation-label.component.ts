import { Component, OnInit, Input } from '@angular/core';
import { ConjugationClass } from '../models/conjugationclass';

@Component({
  selector: 'app-conjugation-label',
  templateUrl: './conjugation-label.component.html',
  styleUrls: ['./conjugation-label.component.css']
})
export class ConjugationLabelComponent implements OnInit {

  @Input() public conjugationClass: ConjugationClass;
  constructor() { }

  ngOnInit(): void {
  }

  showDetails(event: Event): void {
    console.log(event);
  }
}