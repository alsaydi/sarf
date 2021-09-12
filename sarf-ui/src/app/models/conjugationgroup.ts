import { ConjugationClass } from './conjugationclass';

export class ConjugationGroup {
    public static TriUnaugmentedLabel = 'الأفعال الثلاثية المجردة';
    public static TriAugmentedByOneLabel = 'الأفعال الثلاثية المزيدة بحرف';
    public static TriAugmentedByTwoLabel = 'الأفعال الثلاثية المزيدة بحرفين';
    public static TriAugmentedByThreeLabel = 'الأفعال الثلاثية المزيدة بثلاثة أحرف';

    constructor(public label: string, public conjugationClasses: ConjugationClass[]) {
    }
}
