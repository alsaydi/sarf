import { Component, OnInit, Input } from '@angular/core';
import { TrilateralConjugationGroup } from '../models/trilateral-conjugation-group';
import { ConjugationGroup } from '../models/conjugationgroup';
import { ConjugationClass } from '../models/conjugationclass';

@Component({
  selector: 'app-trilateral-conjugation-panel',
  templateUrl: './trilateral-conjugation-panel.component.html',
  styleUrls: ['./trilateral-conjugation-panel.component.css']
})
export class TrilateralConjugationPanelComponent implements OnInit {
  @Input() conjugationGroup: TrilateralConjugationGroup;

  constructor() { }

  ngOnInit(): void { 
    const unaugmented = this.buildUnaugmentedConjugationClasses();
    const augmentedByOne = this.buildAugmentedByOneConjugationClasses();
    const augmentedByTwo = this.buildAugmentedByTwoConjugationClasses();
    const augmentedByThreeOrMore = this.buildAugmentedByThreeConjugationClasses();

    this.conjugationGroup = new TrilateralConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo, augmentedByThreeOrMore);
  }

  public getunaugmented(): ConjugationGroup {
    return this.conjugationGroup.unaugmented;
  }

  private buildUnaugmentedConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [new ConjugationClass(1, 'فعَل يفْعُل', '')
    , new ConjugationClass(2, 'فعَل يفْعِل', '')
    , new ConjugationClass(3, 'فعَل يفْعَل', '')
    , new ConjugationClass(4, 'فعِل يفْعَل', '')
    , new ConjugationClass(5, 'فعُل يفْعُل', '')
    , new ConjugationClass(6, 'فعِل يفْعِل', '')
    ];
    return new ConjugationGroup('الأفعال الثلاثية المجردة', conjugationClasses);
  }

  private buildAugmentedByOneConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [
    new ConjugationClass(1, 'أفْعَل يُفْعِل', ''),
    new ConjugationClass(2, 'فعَّل يُفْعِّل', ''),
    new ConjugationClass(3, 'فاعَل يُفاعِل', '')
    ];
    return new ConjugationGroup('الأفعال الثلاثية المزيدة بحرف', conjugationClasses);
  }

  private buildAugmentedByTwoConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] =[
    new ConjugationClass(1, 'انْفَعَل يَنْفَعِل', ''),
    new ConjugationClass(2, 'افْتَعَل يَفْتَعِل', ''),
    new ConjugationClass(3, 'افْعَلَّ يَفْعَلُّ', ''),
    new ConjugationClass(4, 'تَفاعَل يَتَفاعَل', ''),
    new ConjugationClass(5, 'تَفَعَّل يَتَفَعَّل', '')];
    return new ConjugationGroup('الأفعال الثلاثية المزيدة بحرفين', conjugationClasses);
  }

  private buildAugmentedByThreeConjugationClasses(): ConjugationGroup {
    const conjugationClasses: ConjugationClass[] = [
    new ConjugationClass(1, 'اسْتَفْعَل يَسْتَفْعِل', ''),
    new ConjugationClass(2, 'افْعَوْعَل يَفْعَوْعِل', ''),
    new ConjugationClass(3, 'افْعَوَّل يَفْعَوِّل', ''),
    new ConjugationClass(4, 'افْعَالَّ يَفْعَالُّ', '')];
    return new ConjugationGroup('الأفعال الثلاثية المزيدة بثلاثة أحرف', conjugationClasses);
  }
}
