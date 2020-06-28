import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ConjugationClass } from '../models/conjugationclass';
import { ConjugationGroup } from '../models/conjugationgroup';

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
}
