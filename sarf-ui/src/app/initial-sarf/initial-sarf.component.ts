import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment } from '@angular/router';
import { Utils } from '../models/Utils';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';
import { AppNotificationsService } from '../services/app-notifications.service';

@Component({
  selector: 'app-initial-sarf',
  templateUrl: './initial-sarf.component.html',
  styleUrls: ['./initial-sarf.component.css']
})
export class InitialSarfComponent implements OnInit {

  private verbSelectionDetail: VerbSelectionDetail;

  public verb: string;
  public conjugationClass: number;
  public formula: number;
  constructor(private route: ActivatedRoute, private appNotificationService: AppNotificationsService) { }

  ngOnInit(): void {
    this.verbSelectionDetail = Utils.getVerbSelectionDetail(this.route);
    this.appNotificationService.broadcastVerbSelected(this.verbSelectionDetail);
  }

  getActiveLink(): string {
    return this.getPath() + "/active";
  }

  getPassiveLink(): string {
    return this.getPath() + "/passive";
  }

  getNounsLink(): string {
    return this.getPath() + "/nouns";
  }

  getGerundsLink(): string {
    return this.getPath() + "/gerunds";
  }


  private getPath(): String {
    return "/" + this.route.snapshot.url.map(m => m.path).join("/");
  }
}
