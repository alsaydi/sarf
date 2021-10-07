import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-nouns-listing',
  templateUrl: './nouns-listing.component.html',
  styleUrls: ['./nouns-listing.component.css']
})
export class NounsListingComponent implements OnInit {

  @Input() indefiniteNouns: Array<string>;
  @Input() annexedNouns: Array<string>;
  @Input() definiteNouns: Array<string>;
  @Input() isElative: boolean = false;
  @Input() annexedToIndefinite: Array<string>;
  @Input() annexedToDefinite: Array<string>;
  //[annexedToIndefinite]="elative.annexedToIndefinite" [annexedToDefinite]="elative.annexedToDefinite"
  nouns: Array<string>;
  case: string;
  constructor() { }

  ngOnInit(): void {
    this.setCase(this.isElative ? 'annexedToDefinite' : 'indefinite');
  }

  isCaseButtonDisabled(theCase: string): boolean {
    return this.case === theCase;
  }

  setCase(theCase: string) {
    this.case = theCase;
    if (this.isElative) {
      if (this.case === 'definite') {
        this.nouns = this.definiteNouns;
      } else if (this.case === 'annexedToIndefinite') {
        this.nouns = this.annexedToIndefinite;
      } else if (this.case === 'annexedToDefinite') {
        this.nouns = this.annexedToDefinite;
      } else {
        this.nouns = this.indefiniteNouns;
      }
    }
    else {
      if (this.case === 'definite') {
        this.nouns = this.definiteNouns;
      } else if (this.case === 'annexed') {
        this.nouns = this.annexedNouns;
      } else {
        this.nouns = this.indefiniteNouns;
      }
    }
  }
}
