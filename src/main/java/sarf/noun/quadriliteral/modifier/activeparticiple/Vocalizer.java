package sarf.noun.quadriliteral.modifier.activeparticiple;

import java.util.*;

import sarf.noun.*;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.substitution.*;

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
public class Vocalizer extends QuadrilateralNounSubstitutionApplier implements IQuadrilateralModifier {
    List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (هذا المقلسِي، )
        substitutions.add(new SuffixSubstitution("ِيَ","ِيَ"));// EX: (رأيتُ المقلسِيَ ، )
        substitutions.add(new SuffixSubstitution("ِيِ","ِي"));// EX: (مررتُ على المقلسِي ، )
        substitutions.add(new InfixSubstitution("ِيٌ","ٍ"));// EX: (هذا مقلسٍ)
        substitutions.add(new InfixSubstitution("ِيٍ","ٍ"));// EX: (مررتُ على مقلسٍ)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (مقلسُونَ ، )
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (مقلسِينَ ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ي';
    }
}
