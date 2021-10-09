import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-sarf-verb-pronouns',
  templateUrl: './sarf-verb-pronouns.component.html',
  styleUrls: ['./sarf-verb-pronouns.component.css']
})
export class SarfVerbPronounsComponent implements OnInit {

  @Input() verbs: string[];
  constructor() {
    this.verbs = Array<string>(13);
    for(var i = 0; i < 13; i++) {
      this.verbs[i] = "-";
    }
  }

  ngOnInit(): void {    
  }

}
