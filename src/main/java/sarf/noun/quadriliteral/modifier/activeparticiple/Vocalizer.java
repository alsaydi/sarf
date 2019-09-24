package sarf.noun.quadriliteral.modifier.activeparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.quadriliteral.QuadriConjugationResult;
import sarf.verb.quadriliteral.substitution.InfixSubstitution;
import sarf.verb.quadriliteral.substitution.Substitution;
import sarf.verb.quadriliteral.substitution.SuffixSubstitution;

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

    public boolean isApplied(QuadriConjugationResult quadriConjugationResult) {
        return quadriConjugationResult.getRoot().getC4() == 'ي';
    }
}
