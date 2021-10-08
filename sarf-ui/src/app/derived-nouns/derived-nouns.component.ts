import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { DerivedNoun } from '../models/derived-noun';
import { Utils } from '../models/Utils';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-derived-nouns',
  templateUrl: './derived-nouns.component.html',
  styleUrls: ['./derived-nouns.component.css']
})
export class DerivedNounsComponent implements OnInit, OnDestroy {

  private serviceSubscription: Subscription;
  isUnaugmentedTri: boolean;
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
    this.isUnaugmentedTri = verbSelectionDetail.isTri && !verbSelectionDetail.isAugmented;
    this.serviceSubscription = this.sarfService.getDerivedNouns(verbSelectionDetail).subscribe(result => {
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

  showSubTabs(): boolean {
    return this.isUnaugmentedTri
    || [this.activeParticiples.length, this.passiveParticiples.length, this.timeAndPlaceNouns.length].reduce((a,b) => a+b) > 3; /* one of these nouns has two or more variations */
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }
  
  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
