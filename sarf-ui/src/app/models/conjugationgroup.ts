import { IConjugationClass } from './conjugationclass';

export class ConjugationGroup {
    public static TriUnaugmentedLabel = 'الأفعال الثلاثية المجردة';
    public static TriAugmentedByOneLabel = 'الأفعال الثلاثية المزيدة بحرف';
    public static TriAugmentedByTwoLabel = 'الأفعال الثلاثية المزيدة بحرفين';
    public static TriAugmentedByThreeLabel = 'الأفعال الثلاثية المزيدة بثلاثة أحرف';

    public static QuadUnaugmentedLabel = 'الأفعال الرباعية المجردة';
    public static QuadAugmentedByOneLabel = 'الأفعال الرباعية المزيدة بحرف';
    public static QuadAugmentedByTwoLabel = 'الأفعال الرباعية المزيدة بحرفين';

    constructor(public label: string, public conjugationClasses: IConjugationClass[]) {
    }
}
