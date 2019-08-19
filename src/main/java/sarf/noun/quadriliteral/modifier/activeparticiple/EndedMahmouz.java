package sarf.noun.quadriliteral.modifier.activeparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.substitution.InfixSubstitution;
import sarf.verb.quadriliteral.substitution.Substitution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class EndedMahmouz extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    EndedMahmouz() {
        substitutions.add(new InfixSubstitution("ِء", "ِئ"));// EX: (مُغَرْقِئٌ، مُحْبَنْطِئٌ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ء';
    }
}
