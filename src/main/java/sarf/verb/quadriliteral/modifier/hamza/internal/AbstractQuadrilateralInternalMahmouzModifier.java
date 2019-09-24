package sarf.verb.quadriliteral.modifier.hamza.internal;

import sarf.verb.quadriliteral.QuadriConjugationResult;
import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;

public abstract class AbstractQuadrilateralInternalMahmouzModifier extends SubstitutionsApplier {
    public boolean isApplied(QuadriConjugationResult quadriConjugationResult) {
        return quadriConjugationResult.getRoot().getC2() == 'ء' || quadriConjugationResult.getRoot().getC3() == 'ء';
    }
}
