import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-nouns-listing',
  templateUrl: './nouns-listing.component.html',
  styleUrls: ['./nouns-listing.component.css']
})
export class NounsListingComponent implements OnInit {

  @Input() indefiniteNouns : Array<string>;
  @Input() annexedNouns : Array<string>;
  @Input() definiteNouns : Array<string>;
  @Input() isElative: boolean = false;
  nouns: Array<string>;
  case: string;
  constructor() { }
  
  ngOnInit(): void {
    this.case = this.isElative ? 'annexedToDefinite' : 'indefinite';
    this.nouns = this.indefiniteNouns;
  }

  isCaseButtonDisabled(theCase: string): boolean {
    return this.case === theCase;
  }

  setCase(theCase: string) {
    this.case = theCase;
    if(this.case === 'definite') {
      this.nouns = this.definiteNouns;
    }else if(this.case === 'annexed') {
      this.nouns = this.annexedNouns;
    }else {
      this.nouns = this.indefiniteNouns;
    }
  }
}
