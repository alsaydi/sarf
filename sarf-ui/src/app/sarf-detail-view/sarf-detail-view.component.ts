import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, PRIMARY_OUTLET, UrlSegment, UrlSegmentGroup } from '@angular/router';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';
import { AppNotificationsService } from '../services/app-notifications.service';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-sarf-detail-view',
  templateUrl: './sarf-detail-view.component.html',
  styleUrls: ['./sarf-detail-view.component.css']
})
export class SarfDetailViewComponent implements OnInit {

  private tri: string = 'tri';
  private quad: string = 'quad';
  private unaugmented: string = 'u';
  private augmented: string = 'a';

  public verb: string;
  public conjugationClass: number;
  public formula: number;
  constructor(private route: ActivatedRoute, private appNotificationService: AppNotificationsService) { }

  ngOnInit(): void {
    this.verb = this.route.snapshot.paramMap.get('verb');
    const segments: UrlSegment[] = this.route.snapshot.url;

    const verbSize = segments[1].path;
    const augmentation = segments[2].path;
    if (verbSize === this.tri) {
      if (augmentation === this.unaugmented) {
        this.conjugationClass = Number.parseInt(this.route.snapshot.paramMap.get('class'));
      }
      else if (augmentation === this.augmented) {
        this.formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }
    else if (verbSize === this.quad) {
      if (augmentation == this.augmented) {
        this.formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }

    const verbSelectionDetail: VerbSelectionDetail =
    {
      isTri: verbSize === this.tri,
      isAugmented: augmentation === this.augmented,
      formula: this.formula,
      conjugationClass: this.conjugationClass
    };

    this.appNotificationService.broadcastVerbSelected(verbSelectionDetail);
  }
}
