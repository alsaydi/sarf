import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-sarf-verb-pronouns',
  templateUrl: './sarf-verb-pronouns.component.html',
  styleUrls: ['./sarf-verb-pronouns.component.css']
})
export class SarfVerbPronounsComponent implements OnInit {

  @Input() public verbs: Array<string>;
  constructor() { }

  ngOnInit(): void {
  }

}
