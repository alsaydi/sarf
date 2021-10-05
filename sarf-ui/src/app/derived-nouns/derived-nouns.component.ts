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
  passiveParticiples: Array<DerivedNoun>;
  timeAndPlaceNouns: Array<DerivedNoun>;
  exaggeratedActiveParticiples: Array<DerivedNoun>;
  instrumentalNouns: Array<DerivedNoun>;
  elatives: Array<DerivedNoun>;
  assimilates: Array<DerivedNoun>;
  constructor(private sarfService: SarfService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.sarfService.getDerivedNouns(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.activeParticiples = result.activeParticiples;
      this.passiveParticiples = result.passiveParticiples;
      this.timeAndPlaceNouns = result.timeAndPlaceNouns;
      this.exaggeratedActiveParticiples = result.exaggeratedActiveParticiples;
      this.instrumentalNouns = result.instrumentalNouns;
      this.elatives = result.elatives;
      this.assimilates = result.assimilates;
    });
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }
}
