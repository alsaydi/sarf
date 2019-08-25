package sarf.verb.quadriliteral.modifier.hamza.ended;

import sarf.verb.quadriliteral.QuadriConjugationResult;
import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;

public abstract class AbstractQuadrilateralEndedMahmouzModifier extends SubstitutionsApplier {

    @Override
    public boolean isApplied(QuadriConjugationResult quadriConjugationResult) {
        return quadriConjugationResult.getRoot().getC4() == 'ء';
    }
}
