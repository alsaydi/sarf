import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Utils } from '../models/Utils';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-active-verbs',
  templateUrl: './active-verbs.component.html',
  styleUrls: ['./active-verbs.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ActiveVerbsComponent implements OnInit {

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
    return Utils.getVerbSelectionDetail(this.route);
  }
}
