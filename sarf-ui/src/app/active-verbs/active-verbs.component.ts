import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, UrlSegment } from '@angular/router';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-active-verbs',
  templateUrl: './active-verbs.component.html',
  styleUrls: ['./active-verbs.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ActiveVerbsComponent implements OnInit {

  private tri: string = 'tri';
  private quad: string = 'quad';
  private unaugmented: string = 'u';
  private augmented: string = 'a';
  public past: Array<string>;
  public nominativePresent: Array<string>;
  public accusativePresent: Array<string>;
  public jussivePresent: Array<string>;
  public emphasizedPresent: Array<string>;
  public imperative: Array<string>;
  public emphasizedImperative: Array<string>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.sarfService.getActiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.past = result.past;
      this.nominativePresent = result.nominativePresent;
      this.accusativePresent = result.accusativePresent;
      this.jussivePresent = result.jussivePresent;
      this.emphasizedPresent = result.emphasizedPresent
      this.imperative = result.imperative
      this.emphasizedImperative = result.emphasizedImperative
    });
  }

  private getVerbSelectionDetail() {
    const verb = this.route.snapshot.paramMap.get('verb');
    const segments: UrlSegment[] = this.route.snapshot.url;
    let conjugationClass = 0;
    let formula = 0;

    const verbSize = segments[1].path;
    const augmentation = segments[2].path;
    if (verbSize === this.tri) {
      if (augmentation === this.unaugmented) {
        conjugationClass = Number.parseInt(this.route.snapshot.paramMap.get('class'));
      }
      else if (augmentation === this.augmented) {
        formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }
    else if (verbSize === this.quad) {
      if (augmentation === this.augmented) {
        formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }

    const verbSelectionDetail: VerbSelectionDetail =
    {
      verb: verb,
      isTri: verbSize === this.tri,
      isAugmented: augmentation === this.augmented,
      formula: formula,
      conjugationClass: conjugationClass
    };
    return verbSelectionDetail;
  }
}
