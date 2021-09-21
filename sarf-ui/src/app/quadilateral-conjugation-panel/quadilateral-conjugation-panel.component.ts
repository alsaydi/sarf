import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AugmentedQuadConjugationClass, ConjugationClassStatic, IConjugationClass, UnaugmentedQuadConjugationClass } from '../models/conjugationclass';
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
  public alternatives: Array<any>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute
    , private router: Router){}

  ngOnInit(): void {
    this.conjugationGroup = null;
    // tslint:disable-next-line:no-console
    const currentRoot = this.resetSearch();
    this.sarfService.findTrilateralConjugations(currentRoot).subscribe(rootResult => {
      console.log(rootResult);
        this.processQuadResult(rootResult);
    }, n => console.log(n));
  }

  public navigatTo(path: string) {
    this.router.navigateByUrl('/', {skipLocationChange: true})
    .then(() => this.router.navigate([path]));
  }

  private resetSearch() {
    const currentRoot = this.route.snapshot.paramMap.get('root');
    this.conjugationGroup = null;
    this.alternatives = null;
    return currentRoot;
  }

  public hasSingleResult(): boolean {
    return this.conjugationGroup != null;
  }

  public hasAlternatives(): boolean {
    return this.alternatives != null && this.alternatives.length > 1;
  }

  private processQuadResult(rootResult: any) {
    if (rootResult == null || rootResult.length == 0) {
      return;
    }

    if (rootResult.length > 1) {
      this.alternatives = rootResult.map(root => ({
        "path": `/tri/${root.root}`,
        "display": root.root
      }));
      return;
    }

    const result = rootResult[0];
    const root = result.root;
    const unaugmented = this.buildQuadUnaugmentedConjugationClasses(result.unaugmentedRoots, root);
    const augmentedByOne = this.buildQuadAugmentedByOneConjugationClasses(result.conjugationResults, root);
    const augmentedByTwo = this.buildQuadAugmentedByTwoConjugationClasses(result.conjugationResults, root);
    this.conjugationGroup = new QuadConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo);
  }

  private buildQuadUnaugmentedConjugationClasses(unaugmentedRoots: Array<any>, root: string): ConjugationGroup {
    if (!unaugmentedRoots) {
      return;
    }

    var first = unaugmentedRoots ? unaugmentedRoots[0].display : "";
    const conjugationClasses: IConjugationClass[] =
      [
        new UnaugmentedQuadConjugationClass(ConjugationClassStatic.QuadFirstClassLabel, first, root)
      ];
    return new ConjugationGroup(ConjugationGroup.QuadUnaugmentedLabel, conjugationClasses);
  }

  private buildQuadAugmentedByOneConjugationClasses(conjugationResults: Array<any>, root: string): ConjugationGroup {
    var formula1 = this.getAugmentedRootText(conjugationResults, 1);
    const conjugationClasses: IConjugationClass[] = [
      new AugmentedQuadConjugationClass(1, ConjugationClassStatic.QuadAugmentedFormulaLabel1, formula1, root),
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByOneLabel, conjugationClasses);
  }

  private buildQuadAugmentedByTwoConjugationClasses(conjugationResults: Array<any>, root: string): ConjugationGroup {
    var formula2 = this.getAugmentedRootText(conjugationResults, 2);
    var formula3 = this.getAugmentedRootText(conjugationResults, 3);

    const conjugationClasses: IConjugationClass[] = [
      new AugmentedQuadConjugationClass(3, ConjugationClassStatic.QuadAugmentedFormulaLabel3, formula3, root),
      new AugmentedQuadConjugationClass(2, ConjugationClassStatic.QuadAugmentedFormulaLabel2, formula2, root)
    ];
    return new ConjugationGroup(ConjugationGroup.QuadAugmentedByTwoLabel, conjugationClasses);
  }

  private getAugmentedRootText(conjugationResults: any, formulaNo: number) {
    return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
      .map(r => r.display)
      .join('');
  }
}
