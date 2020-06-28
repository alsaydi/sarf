import { ConjugationGroup } from './conjugationgroup';

export class TrilateralConjugationGroup {
    constructor(public unaugmented: ConjugationGroup
        ,       public augmentedByOne: ConjugationGroup
        ,       public augmentedByTwo: ConjugationGroup
        ,       public augmentedByThreeOrMore: ConjugationGroup) {
    }
}

