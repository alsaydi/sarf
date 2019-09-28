package sarf.verb.quadriliteral.modifier.hamza.ended;

import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;
import sarf.ConjugationResult;

public abstract class AbstractQuadrilateralEndedMahmouzModifier extends SubstitutionsApplier {

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getCharacters().isEmpty()) {
            return false;
        }
        if (conjugationResult.getRoot().getCharacters().size() < 4) {
            return false;
        }
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ء';
    }
}
