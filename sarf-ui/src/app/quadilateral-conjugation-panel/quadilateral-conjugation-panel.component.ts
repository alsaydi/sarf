import { Component, OnInit, Input } from '@angular/core';
import { ConjugationClass } from '../models/conjugationclass';
import { TrilateralConjugationGroup } from '../models/trilateral-conjugation-group';
import { ConjugationGroup } from '../models/conjugationgroup';

@Component({
  selector: 'app-quadilateral-conjugation-panel',
  templateUrl: './quadilateral-conjugation-panel.component.html',
  styleUrls: ['./quadilateral-conjugation-panel.component.css']
})
export class QuadilateralConjugationPanelComponent implements OnInit {
  @Input() conjugationGroup: TrilateralConjugationGroup;

  constructor() { }

  ngOnInit(): void {
    const unaugmented = this.buildUnaugmentedConjugationClasses();
    const augmentedByOne = this.buildAugmentedByOneConjugationClasses();
    const augmentedByTwo = this.buildAugmentedByTwoConjugationClasses();

    this.conjugationGroup = new TrilateralConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo, null);
  }

  private buildUnaugmentedConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [new ConjugationClass(1, 'فَعْلَل يُفَعْلِل', '')];
    return new ConjugationGroup('الأفعال الرباعية المجردة', conjugationClasses);
  }

  private buildAugmentedByOneConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [
    new ConjugationClass(1, 'تَفْعَل يَتَفَعْلَل', ''),
    ];
    return new ConjugationGroup('الأفعال الرباعية المزيدة بحرف', conjugationClasses);
  }

  private buildAugmentedByTwoConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [
    new ConjugationClass(1, 'افْعَلَلّ يَفعَلِلّ', ''),
    new ConjugationClass(2, 'افْعَنْلَل يَفْعَنْلِل', '')];
    return new ConjugationGroup('الأفعال الرباعية المزيدة بحرفين', conjugationClasses);
  }
}
