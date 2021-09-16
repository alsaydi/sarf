import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { Router } from '@angular/router';
import { RootType } from '../root-type.enum';
import { AppNotificationsService } from '../services/app-notifications.service';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}


@Component({
  selector: 'app-rootsearch',
  templateUrl: './rootsearch.component.html',
  styleUrls: ['./rootsearch.component.css']
})

export class RootsearchComponent implements OnInit {
  rootFormControl = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  public verbType: string;
  private hamzaString = "أؤئإ";

  constructor(private appNotificationsService: AppNotificationsService
    , private router: Router) {
    this.appNotificationsService.rootResultRetrieved$.subscribe(
      rootResult => this.processRootResult(rootResult)
      , err => {
        console.error(err);
      }, () => { });
  }
  processRootResult(rootResult: any): void {
    if (rootResult == null) {
      return;
    }

    this.rootFormControl.setValue(rootResult.root);
    //this.verbType = rootResult.
  }

  ngOnInit(): void { }

  public isTri(): boolean {
    return this.getRootType() === RootType.Tri;
  }

  public search(event: any): void {
    const currentRoot = this.correctHamza(this.rootFormControl.value);
    if(currentRoot !== this.rootFormControl.value) {
      this.rootFormControl.setValue(currentRoot);
    }
    
    // tslint:disable-next-line:no-console
    console.debug(event);

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

  private correctHamza(root: string): string {
    if (root == null)
      return null;


    let newRoot = "";

    for (let i = 0; i < root.length; i++) {
      if (this.hamzaString.indexOf(root[i]) != -1) {
        newRoot += 'ء';
        continue;
      }
      newRoot += root[i];
    }
    return newRoot;
  }
}
