package sarf.verb.quadriliteral.modifier.hamza.internal;

import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;

public abstract class AbstractQuadrilateralInternalMahmouzModifier extends SubstitutionsApplier {
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'ء' || conjugationResult.getRoot().getC3() == 'ء';
    }
}
