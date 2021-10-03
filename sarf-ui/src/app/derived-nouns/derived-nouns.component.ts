import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-derived-nouns',
  templateUrl: './derived-nouns.component.html',
  styleUrls: ['./derived-nouns.component.css']
})
export class DerivedNounsComponent implements OnInit {

  nouns: string[];
  constructor() { }

  ngOnInit(): void {
  }

}
