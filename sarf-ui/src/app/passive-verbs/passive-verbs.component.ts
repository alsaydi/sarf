import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Utils } from '../models/Utils';
import { AppNotificationsService } from '../services/app-notifications.service';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-passive-verbs',
  templateUrl: './passive-verbs.component.html',
  styleUrls: ['./passive-verbs.component.css']
})
export class PassiveVerbsComponent implements OnInit, OnDestroy {

  private serviceSubscription: Subscription;
  public past: Array<string>;
  public nominativePresent: Array<string>;
  public accusativePresent: Array<string>;
  public jussivePresent: Array<string>;
  public emphasizedPresent: Array<string>;
  constructor(private sarfService: SarfService, private route: ActivatedRoute, private appNotificationsService: AppNotificationsService) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.serviceSubscription = this.sarfService.getPassiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.past = result.past;
      this.nominativePresent = result.nominativePresent;
      this.accusativePresent = result.accusativePresent;
      this.jussivePresent = result.jussivePresent;
      this.emphasizedPresent = result.emphasizedPresent
    });
    this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }

  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
