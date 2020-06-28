import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { Conjugationclass } from '../models/conjugationclass';

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

  public conjugationClasses: Conjugationclass[];

  ngOnInit(): void {
    this.conjugationClasses = new Array<Conjugationclass>(6);
    for (let i = 0; i < this.conjugationClasses.length; i++) {
      this.conjugationClasses[i] = new Conjugationclass(i + 1, 'فعل يفعل', 'صبر يصبر');
    }
  }
}
