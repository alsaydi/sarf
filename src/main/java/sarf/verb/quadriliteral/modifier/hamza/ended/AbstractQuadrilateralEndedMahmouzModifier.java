package sarf.verb.quadriliteral.modifier.hamza.ended;

import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;

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
