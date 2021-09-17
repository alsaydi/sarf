import { ConjugationGroup } from './conjugationgroup';

export class QuadConjugationGroup {
    constructor(public unaugmented: ConjugationGroup
        ,       public augmentedByOne: ConjugationGroup
        ,       public augmentedByTwo: ConjugationGroup) {
    }
}

