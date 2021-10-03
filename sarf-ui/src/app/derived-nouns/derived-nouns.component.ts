import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DerivedNoun } from '../models/derived-noun';
import { Utils } from '../models/Utils';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-derived-nouns',
  templateUrl: './derived-nouns.component.html',
  styleUrls: ['./derived-nouns.component.css']
})
export class DerivedNounsComponent implements OnInit {

  nouns: string[];
  activeParticiples: Array<DerivedNoun>;
  constructor(private sarfService: SarfService, private route: ActivatedRoute) { }


  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.sarfService.getDerivedNouns(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.activeParticiples = result.activeParticiples;      
    });
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }
}
