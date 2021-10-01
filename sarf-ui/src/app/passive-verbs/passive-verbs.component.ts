import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Utils } from '../models/Utils';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-passive-verbs',
  templateUrl: './passive-verbs.component.html',
  styleUrls: ['./passive-verbs.component.css']
})
export class PassiveVerbsComponent implements OnInit {
  public past: Array<string>;
  public nominativePresent: Array<string>;
  public accusativePresent: Array<string>;
  public jussivePresent: Array<string>;
  public emphasizedPresent: Array<string>;
  constructor(private sarfService: SarfService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.sarfService.getPassiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.past = result.past;
      this.nominativePresent = result.nominativePresent;
      this.accusativePresent = result.accusativePresent;
      this.jussivePresent = result.jussivePresent;
      this.emphasizedPresent = result.emphasizedPresent
    });
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }
}
