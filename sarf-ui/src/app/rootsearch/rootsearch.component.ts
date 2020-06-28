import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ConjugationClass } from '../models/conjugationclass';
import { ConjugationGroup } from '../models/conjugationgroup';
import { RootType } from '../root-type.enum';

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
  rootFormControl = new FormControl('', [
    Validators.required
  ]);

  matcher = new MyErrorStateMatcher();

  private conjugationClasses: ConjugationClass[];
  public conjugationGroup: ConjugationGroup;

  ngOnInit(): void {
    this.conjugationClasses = new Array<ConjugationClass>(6);
    for (let i = 0; i < this.conjugationClasses.length; i++) {
      this.conjugationClasses[i] = new ConjugationClass(i + 1, 'فعل يفعل', 'صبر يصبر');
    }

    this.conjugationGroup = new ConjugationGroup('الأفعال الثلاثيةالمزيدة', this.conjugationClasses);
  }

  public isTri(): boolean {
    return this.getRootType() === RootType.Tri;
  }

  private getRootType(): RootType {
    if (this.rootFormControl.value == null || this.rootFormControl.value.length === 0) {
      return RootType.None;
    }

    if (this.rootFormControl.value.length === 3) {
      return RootType.Tri;
    }

    return RootType.Quad;
  }

  public showResult(): boolean {
    return this.getRootType() !== RootType.None && this.conjugationGroup != null;
  }
}
