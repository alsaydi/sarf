import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-nouns-listing',
  templateUrl: './nouns-listing.component.html',
  styleUrls: ['./nouns-listing.component.css']
})
export class NounsListingComponent implements OnInit {

  @Input() nouns : Array<string>;
  @Input() isElative: boolean;
  constructor() { }
  
  ngOnInit(): void {
    this.nouns = Array<string>(18);
    for(var i = 0; i < 18; i++) {
      this.nouns[i] = "فاعل " + i;
    }
  }
}
