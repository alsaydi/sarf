import { Component, OnInit } from '@angular/core';
import { TrilateralConjugationGroup } from '../models/trilateral-conjugation-group';
import { ConjugationGroup } from '../models/conjugationgroup';
import { AugmentedTriConjugationClass, ConjugationClassStatic, IConjugationClass, UnaugmentedTriConjugationClass } from '../models/conjugationclass';
import { SarfService } from '../services/sarf-service';
import { ActivatedRoute, Router } from '@angular/router';
import { AppNotificationsService } from '../services/app-notifications.service';

@Component({
  selector: 'app-trilateral-conjugation-panel',
  templateUrl: './trilateral-conjugation-panel.component.html',
  styleUrls: ['./trilateral-conjugation-panel.component.css']
})
export class TrilateralConjugationPanelComponent implements OnInit {
  public conjugationGroup: TrilateralConjugationGroup;
  public alternatives: Array<any>;

  constructor(private sarfService: SarfService, private appNotificationsService: AppNotificationsService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void {
    const currentRoot = this.resetSearch();

    this.sarfService.findTrilateralConjugations(currentRoot).subscribe(rootResult => {
      console.log(rootResult);
      this.processTriResult(rootResult);
    }, n => console.log(n));
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

  public navigatTo(path: string) {
    this.router.navigateByUrl('/', {skipLocationChange: true})
    .then(() => this.router.navigate([path]));
  }

  private processTriResult(rootResult: any) {

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
    const unaugmented = this.buildUnaugmentedConjugationClasses(result.unaugmentedRoots, root);
    const augmentedByOne = this.buildAugmentedByOneConjugationClasses(result.conjugationResults, root);
    const augmentedByTwo = this.buildAugmentedByTwoConjugationClasses(result.conjugationResults, root);
    const augmentedByThreeOrMore = this.buildAugmentedByThreeConjugationClasses(result.conjugationResults, root);

    this.conjugationGroup = new TrilateralConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo, augmentedByThreeOrMore);
    this.appNotificationsService.broadcastRootResult(result);
  }

  private buildUnaugmentedConjugationClasses(unaugmentedRoots: Array<any>, root: string): ConjugationGroup {
    if (!unaugmentedRoots) {
      return;
    }

    const first = this.getTriUnaugmentedRootText(unaugmentedRoots, "First");
    const second = this.getTriUnaugmentedRootText(unaugmentedRoots, "Second");
    const third = this.getTriUnaugmentedRootText(unaugmentedRoots, "Third");
    const forth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Forth");
    const fifth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Fifth");
    const sixth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Sixth");
    const conjugationClasses: IConjugationClass[] =
      [
        new UnaugmentedTriConjugationClass(1, ConjugationClassStatic.TriFirstConjugationClass, first, root)
        , new UnaugmentedTriConjugationClass(2, ConjugationClassStatic.TriSecondConjugationClass, second, root)
        , new UnaugmentedTriConjugationClass(3, ConjugationClassStatic.TriThirdConjugationClass, third, root)
        , new UnaugmentedTriConjugationClass(4, ConjugationClassStatic.TriForthConjugationClass, forth, root)
        , new UnaugmentedTriConjugationClass(5, ConjugationClassStatic.TriFifthConjugationClass, fifth, root)
        , new UnaugmentedTriConjugationClass(6, ConjugationClassStatic.TriSixthConjugationClass, sixth, root)
      ];
    return new ConjugationGroup(ConjugationGroup.TriUnaugmentedLabel, conjugationClasses);
  }

  private getTriUnaugmentedRootText(unaugmentedRoots: any, conjugationclass: string): string {
    return unaugmentedRoots.filter(r => r.root.conjugation === conjugationclass)
      .map(r => r.display)
      .join('');
  }

  private buildAugmentedByOneConjugationClasses(conjugationResults: Array<any>, root: string): ConjugationGroup {
    var formula1 = this.getTriAugmentedRootText(conjugationResults, 1);
    var formula2 = this.getTriAugmentedRootText(conjugationResults, 2);
    var formula3 = this.getTriAugmentedRootText(conjugationResults, 3);
    const conjugationClasses: IConjugationClass[] = [
      new AugmentedTriConjugationClass(1, ConjugationClassStatic.TriAugmentedByOneFirstConjugationClass, formula1, root),
      new AugmentedTriConjugationClass(2, ConjugationClassStatic.TriAugmentedByOneSecondConjugationClass, formula2, root),
      new AugmentedTriConjugationClass(3, ConjugationClassStatic.TriAugmentedByOneThirdConjugationClass, formula3, root)
    ];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByOneLabel, conjugationClasses);
  }

  private buildAugmentedByTwoConjugationClasses(conjugationResults: Array<any>, root: string): ConjugationGroup {
    var formula4 = this.getTriAugmentedRootText(conjugationResults, 4);
    var formula5 = this.getTriAugmentedRootText(conjugationResults, 5);
    var formula6 = this.getTriAugmentedRootText(conjugationResults, 6);
    var formula7 = this.getTriAugmentedRootText(conjugationResults, 7);
    var formula8 = this.getTriAugmentedRootText(conjugationResults, 8);

    const conjugationClasses: IConjugationClass[] = [
      new AugmentedTriConjugationClass(1, ConjugationClassStatic.TriAugmentedByTwoFirstConjugationClass, formula4, root),
      new AugmentedTriConjugationClass(2, ConjugationClassStatic.TriAugmentedByTwoSecondConjugationClass, formula5, root),
      new AugmentedTriConjugationClass(3, ConjugationClassStatic.TriAugmentedByTwoThirdConjugationClass, formula6, root),
      new AugmentedTriConjugationClass(4, ConjugationClassStatic.TriAugmentedByTwoForthConjugationClass, formula7, root),
      new AugmentedTriConjugationClass(5, ConjugationClassStatic.TriAugmentedByTwoFifthConjugationClass, formula8, root)];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByTwoLabel, conjugationClasses);
  }

  private buildAugmentedByThreeConjugationClasses(conjugationResults: Array<any>, root: string): ConjugationGroup {
    var formula9 = this.getTriAugmentedRootText(conjugationResults, 9);
    var formula10 = this.getTriAugmentedRootText(conjugationResults, 10);
    var formula11 = this.getTriAugmentedRootText(conjugationResults, 11);
    var formula12 = this.getTriAugmentedRootText(conjugationResults, 12);

    const conjugationClasses: IConjugationClass[] = [
      new AugmentedTriConjugationClass(1, ConjugationClassStatic.TriAugmentedByThreeFirstConjugationClass, formula9, root),
      new AugmentedTriConjugationClass(2, ConjugationClassStatic.TriAugmentedByThreeSecConjugationClass, formula10, root),
      new AugmentedTriConjugationClass(3, ConjugationClassStatic.TriAugmentedByThreeThirdConjugationClass, formula11, root),
      new AugmentedTriConjugationClass(4, ConjugationClassStatic.TriAugmentedByThreeForthConjugationClass, formula12, root)];
    return new ConjugationGroup(ConjugationGroup.TriAugmentedByThreeLabel, conjugationClasses);
  }

  private getTriAugmentedRootText(conjugationResults: any, formulaNo: number) {
    return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
      .map(r => r.display)
      .join('');
  }
}
