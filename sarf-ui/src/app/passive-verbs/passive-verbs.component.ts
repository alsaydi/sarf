import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Utils } from '../models/Utils';
import { VerbConjugation } from '../models/VerbConjugation';
import { AppNotificationsService } from '../services/app-notifications.service';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-passive-verbs',
  templateUrl: './passive-verbs.component.html',
  styleUrls: ['./passive-verbs.component.css']
})
export class PassiveVerbsComponent implements OnInit, OnDestroy {

  private serviceSubscription: Subscription;
  public pastGroups: Array<VerbConjugation>;
  public nominativePresentGroups: Array<VerbConjugation>;
  public accusativePresentGroups: Array<VerbConjugation>;
  public jussivePresentGroups: Array<VerbConjugation>;
  public emphasizedPresentGroups: Array<VerbConjugation>;

  constructor(private sarfService: SarfService,
              private route: ActivatedRoute,
              private appNotificationsService: AppNotificationsService) { }

  ngOnInit(): void {
    const verbSelectionDetail = Utils.getVerbSelectionDetail(this.route);
    this.serviceSubscription = this.sarfService.getPassiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log('active verbs' , result);
      this.pastGroups = result.map(r => ({key: r.key, verbs: r.past}));
      this.nominativePresentGroups = result.map(r => ({key: r.key, verbs: r.nominativePresent}));
      this.accusativePresentGroups = result.map(r => ({key: r.key, verbs: r.accusativePresent}));
      this.jussivePresentGroups = result.map(r => ({key: r.key, verbs: r.jussivePresent}));
      this.emphasizedPresentGroups = result.map(r => ({key: r.key, verbs: r.emphasizedPresent}));
    });
    this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
  }

  showSubTabs(): boolean {
    return this.pastGroups && this.pastGroups.length > 1;
  }

  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
