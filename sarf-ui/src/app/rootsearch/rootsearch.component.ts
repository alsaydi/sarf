import { Component, OnDestroy, OnInit } from '@angular/core';
import { UntypedFormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';
import { RootType } from '../root-type.enum';
import { AppNotificationsService } from '../services/app-notifications.service';
import { RootExtractionService } from '../services/root-extraction.service';
import { SarfService } from '../services/sarf-service';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: UntypedFormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-rootsearch',
  templateUrl: './rootsearch.component.html',
  styleUrls: ['./rootsearch.component.css']
})

export class RootsearchComponent implements OnInit, OnDestroy {
  rootFormControl = new UntypedFormControl('', [Validators.required]);
  private verbSelectedSubscription: Subscription;
  private rootResultSubscription: Subscription;
  private sarfServiceSubscription: Subscription;
  private rootExtServiceSubscription: Subscription;
  matcher = new MyErrorStateMatcher();
  verbDisplay = '-';
  kindOfVerb = '-';
  transitivity = '-';
  extractedRoots: Array<string>;
  searchWord: string;
  searching: boolean;
  private currentlySelectedRoot: any;

  constructor(private appNotificationsService: AppNotificationsService,
              private sarfService: SarfService,
              private rootExtService: RootExtractionService,
              private router: Router) {
    this.appNotificationsService.rootResultRetrieved$.subscribe(
      rootResult => this.processRootResult(rootResult)
      , err => {
        console.error(err);
      }, () => { });

    this.appNotificationsService.verbSelected$.subscribe(verbSelectionDetail => {
      this.sarfServiceSubscription?.unsubscribe();
      if (this.currentlySelectedRoot == null) {
        this.retrieveBasicRootInfo(verbSelectionDetail);
      }
      else {
        this.processVerbSelection(verbSelectionDetail);
      }
    });
  }

  private retrieveBasicRootInfo(verbSelectionDetail: VerbSelectionDetail) {
    this.sarfServiceSubscription = this.sarfService.findSarf(verbSelectionDetail.verb).subscribe(result => {
      if (!result || result.length === 0) {
        return;
      }
      this.currentlySelectedRoot = result[0];
      this.processVerbSelection(verbSelectionDetail);
    });
  }

  processVerbSelection(verbSelectionDetail: VerbSelectionDetail) {
    if (!this.currentlySelectedRoot) {
      return;
    }

    if (!this.rootFormControl.value) {
      /* this happens when we navigate directly to a page, instead of going through search. */
      this.rootFormControl.setValue(this.currentlySelectedRoot.root);
      this.kindOfVerb = this.currentlySelectedRoot.kindOfVerb;
    }

    let transitiveState = '';
    if (verbSelectionDetail.isAugmented) {
      const selection = this.currentlySelectedRoot.conjugationResults
      .filter(cr => cr.conjugationResult.formulaNo === verbSelectionDetail.formula);
      if (selection && selection.length === 1) {
        transitiveState = selection[0].transitivity;
        this.verbDisplay = selection[0].display;
      }
    } else {
      if (verbSelectionDetail.isTri) {
        const selection = this.currentlySelectedRoot.unaugmentedRoots
        .filter(r => this.conjugationClassToNumber(r.root.conjugation) === verbSelectionDetail.conjugationClass)
        .map(r => r.root.transitive);
        if (selection && selection.length === 1) {
          transitiveState = selection[0];
          this.verbDisplay = this.currentlySelectedRoot.unaugmentedRoots[0].display;
        }
      }
      else {
        const selection = this.currentlySelectedRoot.unaugmentedRoots;
        if (selection && selection.length === 1) {
          transitiveState = selection[0].root.transitive;
          this.verbDisplay = selection[0].display;
        }
      }
    }
    if (transitiveState) {
      this.transitivity = this.getTransitivityDescription(transitiveState);
    }
  }

  private getTransitivityDescription(t: string) {
    switch (t) {
      case 'ك':
        return 'متعد وﻻزم';
      case 'ل':
        return 'ﻻزم';
      case 'م':
        return 'متعد';
      default:
        break;
    }
    return '--';
  }

  private processRootResult(rootResult: any): void {
    if (rootResult == null) {
      return;
    }

    this.currentlySelectedRoot = rootResult;
    this.rootFormControl.setValue(rootResult.root);
    this.kindOfVerb = rootResult.kindOfVerb;
  }

  ngOnInit(): void {
    this.reset();
  }

  private reset() {
    this.currentlySelectedRoot = null;
    this.kindOfVerb = '-';
    this.transitivity = '-';
    this.verbDisplay = '-';
    this.extractedRoots = [];
    this.toggleSearch(false);
  }

  public isTri(): boolean {
    return this.getRootType() === RootType.Tri;
  }

  public search(__: any): void {
    this.reset();
    this.toggleSearch(true);
    const currentRoot = this.rootFormControl.value;
    if (currentRoot !== this.rootFormControl.value) {
      this.rootFormControl.setValue(currentRoot);
    }

    this.sarfServiceSubscription = this.sarfService.findSarf(currentRoot)
    .subscribe(_ => this.redirectToAppropriatePanel(currentRoot)
      , err => {
        if (err && (err.status === 400 || err.status === 404)){
          this.extractRoot(currentRoot);
        }
      }
    , () => this.toggleSearch(false));
  }

  private toggleSearch(showSearchProgresssbar: boolean): void {
    this.searching = showSearchProgresssbar;
    this.router.navigateByUrl('/', { skipLocationChange: false });
  }

  redirectToAppropriatePanel(currentRoot: string) {
    this.rootFormControl.setValue(currentRoot);
    if (this.isTri()) {
      /* this is needed because we want to navigate sometimes from an existing search result (same route)*/
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate([`/tri/${currentRoot}`]);
      });
    } else {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate([`/quad/${currentRoot}`]);
      });
    }
  }

  private extractRoot(word: string) {
    this.searchWord = word;
    this.rootExtServiceSubscription = this.rootExtService.findRoot(word).subscribe(suggestedRoots => {
      if (suggestedRoots != null && suggestedRoots[word] != null) {
            const roots = suggestedRoots[word];
            if (roots) {
              this.extractedRoots = roots;
            }
      }
      if (this.extractedRoots !== null && this.extractedRoots.length === 1) {
        this.rootFormControl.setValue(this.extractedRoots[0]);
        this.redirectToAppropriatePanel(this.extractedRoots[0]);
      }
    }, err => {
      console.error(err);
      this.searching = false;
      this.showNotFound();
     }, () => this.toggleSearch(false));
  }

  private showNotFound() {
    this.router.navigate(['/not-found']);
  }

  private getRootType(): RootType {
    const currentRoot = this.rootFormControl.value;
    if (currentRoot == null || currentRoot.length === 0) {
      return RootType.None;
    }

    if (currentRoot.length === 3) {
      return RootType.Tri;
    }
    if (currentRoot.length === 4) {
      return RootType.Quad;
    }
    return RootType.None;
  }

  isSelected(root: string): boolean {
    if (!root) {
      return false;
    }

    return this.rootFormControl.value === root;
  }

  private conjugationClassToNumber(cclass: string) {
    cclass = cclass.toLocaleLowerCase();
    switch (cclass) {
      case 'first':
        return 1;
      case 'second':
        return 2;
      case 'third':
        return 3;
      case 'forth':
        return 4;
      case 'fifth':
        return 5;
      case 'sixth':
        return 6;
    }
    return 0;
  }

  ngOnDestroy(): void {
    this.verbSelectedSubscription?.unsubscribe();
    this.rootResultSubscription?.unsubscribe();
    this.sarfServiceSubscription?.unsubscribe();
    this.rootExtServiceSubscription?.unsubscribe();
  }
}
