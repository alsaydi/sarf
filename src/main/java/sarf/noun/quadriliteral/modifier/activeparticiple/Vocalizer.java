package sarf.noun.quadriliteral.modifier.activeparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Vocalizer extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي"));// EX: (هذا المقلسِي، )
        substitutions.add(new SuffixSubstitution("ِيَ", "ِيَ"));// EX: (رأيتُ المقلسِيَ ، )
        substitutions.add(new SuffixSubstitution("ِيِ", "ِي"));// EX: (مررتُ على المقلسِي ، )
        substitutions.add(new InfixSubstitution("ِيٌ", "ٍ"));// EX: (هذا مقلسٍ)
        substitutions.add(new InfixSubstitution("ِيٍ", "ٍ"));// EX: (مررتُ على مقلسٍ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ"));// EX: (مقلسُونَ ، )
        substitutions.add(new InfixSubstitution("ِيِ", "ِ"));// EX: (مقلسِينَ ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getCharacters().isEmpty()) {
            return false;
        }
        if (conjugationResult.getRoot().getCharacters().size() < 4) {
            return false;
        }
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ي';
    }
}
