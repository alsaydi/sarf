import { RtlScrollAxisType } from '@angular/cdk/platform';
import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ConjugationClass } from '../models/conjugationclass';
import { ConjugationGroup } from '../models/conjugationgroup';
import { QuadConjugationGroup } from '../models/quad-conjugation-group';
import { TrilateralConjugationGroup } from '../models/trilateral-conjugation-group';
import { RootType } from '../root-type.enum';
import { SarfService } from '../services/sarf-service';

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


  constructor(private sarfService: SarfService) {
  }

  public conjugationGroup: TrilateralConjugationGroup;
  public quadConjugationGroup: QuadConjugationGroup;

  ngOnInit(): void {
  }

  public isTri(): boolean {
    return this.getRootType() === RootType.Tri;
  }

  public search(event: any): void {
    this.conjugationGroup = null;
    this.quadConjugationGroup = null;
    // tslint:disable-next-line:no-console
    console.debug(event);
    this.sarfService.findTrilateralConjugations(this.rootFormControl.value).subscribe(rootResult => {
      console.log(rootResult);
      if (this.isTri()) {
        this.processTriResult(rootResult);
      } else {
        this.processQuadResult(rootResult);
      }

    }, n => console.log(n));
  }

  private processTriResult(rootResult: any) {
    const unaugmented = this.buildUnaugmentedConjugationClasses(rootResult.unaugmentedRoots);
    const augmentedByOne = this.buildAugmentedByOneConjugationClasses(rootResult.conjugationResults);
    const augmentedByTwo = this.buildAugmentedByTwoConjugationClasses(rootResult.conjugationResults);
    const augmentedByThreeOrMore = this.buildAugmentedByThreeConjugationClasses(rootResult.conjugationResults);

    this.conjugationGroup = new TrilateralConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo, augmentedByThreeOrMore);
  }

  private buildUnaugmentedConjugationClasses(unaugmentedRoots): ConjugationGroup {
    if (!unaugmentedRoots) {
      return;
    }

    var first = this.getTriUnaugmentedRootText(unaugmentedRoots, "First");
    var second = this.getTriUnaugmentedRootText(unaugmentedRoots, "Second");
    var third = this.getTriUnaugmentedRootText(unaugmentedRoots, "Third");
    var forth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Forth");
    var fifth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Fifth");
    var sixth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Sixth");
    const conjugationClasses: ConjugationClass[] =
      [
        new ConjugationClass(1, ConjugationClass.TriFirstConjugationClass, first)
        , new ConjugationClass(2, ConjugationClass.TriSecondConjugationClass, second)
        , new ConjugationClass(3, ConjugationClass.TriThirdConjugationClass, third)
        , new ConjugationClass(4, ConjugationClass.TriForthConjugationClass, forth)
        , new ConjugationClass(5, ConjugationClass.TriFifthConjugationClass, fifth)
        , new ConjugationClass(6, ConjugationClass.TriSixthConjugationClass, sixth)
      ];
    return new ConjugationGroup(ConjugationGroup.TriUnaugmentedLabel, conjugationClasses);
  }

  private getTriUnaugmentedRootText(unaugmentedRoots: any, conjugationclass: string) {
    return unaugmentedRoots.filter(r => r.root.conjugation === conjugationclass)
      .map(r => r.display)
      .join('');
  }

  private buildAugmentedByOneConjugationClasses(conjugationResults): ConjugationGroup {
    var formula1 = this.getTriAugmentedRootText(conjugationResults, 1);
    var formula2 = this.getTriAugmentedRootText(conjugationResults, 2);
    var formula3 = this.getTriAugmentedRootText(conjugationResults, 3);
    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(1, ConjugationClass.TriAugmentedByOneFirstConjugationClass, formula1),
      new ConjugationClass(2, ConjugationClass.TriAugmentedByOneSecondConjugationClass, formula2),
      new ConjugationClass(3, ConjugationClass.TriAugmentedByOneThirdConjugationClass, formula3)
    ];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByOneLabel, conjugationClasses);
  }

  private buildAugmentedByTwoConjugationClasses(conjugationResults): ConjugationGroup {
    var formula4 = this.getTriAugmentedRootText(conjugationResults, 4);
    var formula5 = this.getTriAugmentedRootText(conjugationResults, 5);
    var formula6 = this.getTriAugmentedRootText(conjugationResults, 6);
    var formula7 = this.getTriAugmentedRootText(conjugationResults, 7);
    var formula8 = this.getTriAugmentedRootText(conjugationResults, 8);

    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(1, ConjugationClass.TriAugmentedByTwoFirstConjugationClass, formula4),
      new ConjugationClass(2, ConjugationClass.TriAugmentedByTwoSecondConjugationClass, formula5),
      new ConjugationClass(3, ConjugationClass.TriAugmentedByTwoThirdConjugationClass, formula6),
      new ConjugationClass(4, ConjugationClass.TriAugmentedByTwoForthConjugationClass, formula7),
      new ConjugationClass(5, ConjugationClass.TriAugmentedByTwoFifthConjugationClass, formula8)];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByTwoLabel, conjugationClasses);
  }

  private buildAugmentedByThreeConjugationClasses(conjugationResults): ConjugationGroup {
    var formula9 = this.getTriAugmentedRootText(conjugationResults, 9);
    var formula10 = this.getTriAugmentedRootText(conjugationResults, 10);
    var formula11 = this.getTriAugmentedRootText(conjugationResults, 11);
    var formula12 = this.getTriAugmentedRootText(conjugationResults, 12);

    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(1, ConjugationClass.TriAugmentedByThreeFirstConjugationClass, formula9),
      new ConjugationClass(2, ConjugationClass.TriAugmentedByThreeSecConjugationClass, formula10),
      new ConjugationClass(3, ConjugationClass.TriAugmentedByThreeThirdConjugationClass, formula11),
      new ConjugationClass(4, ConjugationClass.TriAugmentedByThreeForthConjugationClass, formula12)];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByThreeLabel, conjugationClasses);
  }

  private getTriAugmentedRootText(conjugationResults: any, formulaNo: number) {
    return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
      .map(r => r.display)
      .join('');
  }

  private processQuadResult(rootResult: any) {
    const unaugmented = this.buildQuadUnaugmentedConjugationClasses(rootResult.unaugmentedRoots);
    const augmentedByOne = this.buildQuadAugmentedByOneConjugationClasses(rootResult.conjugationResults);
    const augmentedByTwo = this.buildQuadAugmentedByTwoConjugationClasses(rootResult.conjugationResults);
    this.quadConjugationGroup = new QuadConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo);
  }

  private buildQuadUnaugmentedConjugationClasses(unaugmentedRoots): ConjugationGroup {
    if (!unaugmentedRoots) {
      return;
    }

    var first = unaugmentedRoots ? unaugmentedRoots[0].display : "";
    const conjugationClasses: ConjugationClass[] =
      [
        new ConjugationClass(1, ConjugationClass.QuadFirstClassLabel, first)
      ];
    return new ConjugationGroup(ConjugationGroup.QuadUnaugmentedLabel, conjugationClasses);
  }

  private buildQuadAugmentedByOneConjugationClasses(conjugationResults): ConjugationGroup {
    var formula1 = this.getTriAugmentedRootText(conjugationResults, 1);
    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(1, ConjugationClass.QuadAugmentedFormulaLabel1, formula1),
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByOneLabel, conjugationClasses);
  }

  private buildQuadAugmentedByTwoConjugationClasses(conjugationResults): ConjugationGroup {
    var formula2 = this.getTriAugmentedRootText(conjugationResults, 2);
    var formula3 = this.getTriAugmentedRootText(conjugationResults, 3);

    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(2, ConjugationClass.QuadAugmentedFormulaLabel3, formula3),
      new ConjugationClass(1, ConjugationClass.QuadAugmentedFormulaLabel2, formula2)
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByTwoLabel, conjugationClasses);
  }

  private getRootType(): RootType {
    if (this.rootFormControl.value == null || this.rootFormControl.value.length === 0) {
      return RootType.None;
    }

    if (this.rootFormControl.value.length === 3) {
      return RootType.Tri;
    }
    if (this.rootFormControl.value.length === 4) {
      return RootType.Quad;
    }
    return RootType.None;
  }

  public showResult(): boolean {
    return this.getRootType() !== RootType.None && (this.conjugationGroup != null || this.quadConjugationGroup != null);
  }
}

