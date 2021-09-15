import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConjugationClass } from '../models/conjugationclass';
import { ConjugationGroup } from '../models/conjugationgroup';
import { QuadConjugationGroup } from '../models/quad-conjugation-group';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-quadilateral-conjugation-panel',
  templateUrl: './quadilateral-conjugation-panel.component.html',
  styleUrls: ['./quadilateral-conjugation-panel.component.css']
})
export class QuadilateralConjugationPanelComponent implements OnInit {
  public conjugationGroup: QuadConjugationGroup;

  constructor(private sarfService: SarfService,
    private route: ActivatedRoute){}

  ngOnInit(): void {
    this.conjugationGroup = null;
    // tslint:disable-next-line:no-console
    const currentRoot = this.route.snapshot.paramMap.get('root');
    this.sarfService.findTrilateralConjugations(currentRoot).subscribe(rootResult => {
      console.log(rootResult);
        this.processQuadResult(rootResult);
    }, n => console.log(n));
  }

  private processQuadResult(rootResult: any) {
    const unaugmented = this.buildQuadUnaugmentedConjugationClasses(rootResult.unaugmentedRoots);
    const augmentedByOne = this.buildQuadAugmentedByOneConjugationClasses(rootResult.conjugationResults);
    const augmentedByTwo = this.buildQuadAugmentedByTwoConjugationClasses(rootResult.conjugationResults);
    this.conjugationGroup = new QuadConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo);
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
    var formula1 = this.getAugmentedRootText(conjugationResults, 1);
    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(1, ConjugationClass.QuadAugmentedFormulaLabel1, formula1),
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByOneLabel, conjugationClasses);
  }

  private buildQuadAugmentedByTwoConjugationClasses(conjugationResults): ConjugationGroup {
    var formula2 = this.getAugmentedRootText(conjugationResults, 2);
    var formula3 = this.getAugmentedRootText(conjugationResults, 3);

    const conjugationClasses: ConjugationClass[] = [
      new ConjugationClass(2, ConjugationClass.QuadAugmentedFormulaLabel3, formula3),
      new ConjugationClass(1, ConjugationClass.QuadAugmentedFormulaLabel2, formula2)
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByTwoLabel, conjugationClasses);
  }

  private getAugmentedRootText(conjugationResults: any, formulaNo: number) {
    return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
      .map(r => r.display)
      .join('');
  }
}
