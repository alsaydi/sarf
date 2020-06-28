import { ConjugationClass } from './conjugationclass';

export class ConjugationGroup {
    constructor(public label: string, public conjugationClasses: ConjugationClass[]) {
    }
}
