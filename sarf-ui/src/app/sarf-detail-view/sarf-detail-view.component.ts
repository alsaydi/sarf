import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, PRIMARY_OUTLET, UrlSegment, UrlSegmentGroup } from '@angular/router';

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
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.verb = this.route.snapshot.paramMap.get('verb');    
    const segments: UrlSegment[] = this.route.snapshot.url;
    
    const verbSize = segments[1].path;
    const augmentation = segments[2].path;
    if(verbSize === this.tri) {
      if(augmentation === this.unaugmented) {
        this.conjugationClass = Number.parseInt(this.route.snapshot.paramMap.get('class'));
      }
      else if(augmentation === this.augmented) {
        this.formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }
    else if(verbSize === this.quad) {
      if(augmentation == this.augmented) {
        this.formula = Number.parseInt(this.route.snapshot.paramMap.get('formula'));
      }
    }
  }
}
