export class ConjugationClassStatic {

    public static TriFirstConjugationClass = 'فعَل يفْعُل';
    public static TriSecondConjugationClass = 'فعَل يفْعِل';
    public static TriThirdConjugationClass = 'فعَل يفْعَل';
    public static TriForthConjugationClass = 'فعِل يفْعَل';
    public static TriFifthConjugationClass = 'فعُل يفْعُل';
    public static TriSixthConjugationClass = 'فعِل يفْعِل';
    public static TriAugmentedByOneFirstConjugationClass = 'أفْعَل يُفْعِل';
    public static TriAugmentedByOneSecondConjugationClass = 'فعَّل يُفْعِّل';
    public static TriAugmentedByOneThirdConjugationClass = 'فاعَل يُفاعِل';
    public static TriAugmentedByTwoFirstConjugationClass = 'انْفَعَل يَنْفَعِل';
    public static TriAugmentedByTwoSecondConjugationClass = 'افْتَعَل يَفْتَعِل';
    public static TriAugmentedByTwoThirdConjugationClass = 'افْعَلَّ يَفْعَلُّ';
    public static TriAugmentedByTwoForthConjugationClass = 'تَفاعَل يَتَفاعَل';
    public static TriAugmentedByTwoFifthConjugationClass = 'تَفَعَّل يَتَفَعَّل';
    public static TriAugmentedByThreeFirstConjugationClass = 'اسْتَفْعَل يَسْتَفْعِل';
    public static TriAugmentedByThreeSecConjugationClass = 'افْعَوْعَل يَفْعَوْعِل';
    public static TriAugmentedByThreeThirdConjugationClass = 'افْعَوَّل يَفْعَوِّل';
    public static TriAugmentedByThreeForthConjugationClass = 'افْعَالَّ يَفْعَالُّ';

    public static QuadFirstClassLabel = 'فَعْلَل يُفَعْلِل';
    public static QuadAugmentedFormulaLabel1 = 'تَفْعَل يَتَفَعْلَل';
    public static QuadAugmentedFormulaLabel3 = 'افْعَلَلّ يَفعَلِلّ';
    public static QuadAugmentedFormulaLabel2 = 'افْعَنْلَل يَفْعَنْلِل';
}

export interface IConjugationClass {
    readonly reference: string;
    readonly content: string;
    readonly label: string;
}

export class UnaugmentedTriConjugationClass implements IConjugationClass {
    public constructor(public classNumber: number, public label: string, public content: string, public root: string) {
        this.reference = `/verb/tri/u/${root}/${classNumber}`;
    }
    reference: string;
}

export class AugmentedTriConjugationClass implements IConjugationClass {
    public constructor(public formulaNumber: number, public label: string, public content: string, public root: string) {
        this.reference = `/verb/tri/a/${root}/${formulaNumber}`;
    }
    reference: string;
}

export class UnaugmentedQuadConjugationClass implements IConjugationClass {
    public constructor(public label: string, public content: string, public root: string) {
        this.reference = `/verb/quad/u/${root}`;
    }
    reference: string;
}

export class AugmentedQuadConjugationClass implements IConjugationClass {
    public constructor(public formulaNumber: number, public label: string, public content: string, public root: string) {
        this.reference = `/verb/quad/a/${root}/${formulaNumber}`;
    }
    reference: string;
}
