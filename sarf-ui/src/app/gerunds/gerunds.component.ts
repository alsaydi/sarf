import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DerivedNoun } from '../models/derived-noun';
import { Utils } from '../models/Utils';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-gerunds',
  templateUrl: './gerunds.component.html',
  styleUrls: ['./gerunds.component.css']
})
export class GerundsComponent implements OnInit {

  standards: Array<DerivedNoun>;
  meems: Array<DerivedNoun>;
  nomens: Array<DerivedNoun>;
  qualityGerunds: Array<DerivedNoun>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.sarfService.getGerunds(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.standards = result.standards;
    });
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }
}
