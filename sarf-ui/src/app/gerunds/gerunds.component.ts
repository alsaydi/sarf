import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { DerivedNoun } from '../models/derived-noun';
import { Utils } from '../models/Utils';
import { AppNotificationsService } from '../services/app-notifications.service';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-gerunds',
  templateUrl: './gerunds.component.html',
  styleUrls: ['./gerunds.component.css']
})
export class GerundsComponent implements OnInit, OnDestroy {

  private serviceSubscription: Subscription;
  isUnaugmentedTri: boolean;
  standards: Array<DerivedNoun>;
  meems: Array<DerivedNoun>;
  nomens: Array<DerivedNoun>;
  qualityGerunds: Array<DerivedNoun>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute, private appNotificationsService: AppNotificationsService) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.isUnaugmentedTri = verbSelectionDetail.isTri && !verbSelectionDetail.isAugmented;
    this.serviceSubscription = this.sarfService.getGerunds(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.standards = result.standards;
      this.meems = result.meems;
      this.nomens = result.nomens;
      this.qualityGerunds = result.qualityGerunds;
    });
    this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }

  showSubTabs(): boolean {
    return this.isUnaugmentedTri
    || [this.standards?.length, this.meems?.length, this.nomens?.length].reduce((a,b) => a+b) > 3; /* one of these nouns has two or more variations */
  }

  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
