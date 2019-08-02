package sarf.verb.quadriliteral.modifier.hamza.ended;

import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;

public abstract class AbstractQuadrilateralEndedMahmouzModifier extends SubstitutionsApplier {

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ء';
    }
}
