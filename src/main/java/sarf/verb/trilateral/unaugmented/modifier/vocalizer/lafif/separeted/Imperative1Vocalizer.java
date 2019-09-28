package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("ايْC2ِيْ","C2ِ"));// EX: (دِ)
        substitutions.add(new ExpressionInfixSubstitution("ايْC2ِيِ","C2ِ"));// EX: (أنتِ دِي)
        substitutions.add(new ExpressionInfixSubstitution("ايْC2ِيْ","C2ِي"));// EX: (أنتن دِينَ)
        substitutions.add(new ExpressionInfixSubstitution("ايْC2ِيُ","C2ُ"));// EX: (أنتم دُوا)
        substitutions.add(new ExpressionInfixSubstitution("ايْC2ِيَ","C2ِيَ"));// EX: (أنتما دِيا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (conjugationResult.getRoot().getC1()=='ي' && kov == KindOfVerb.Lafeef_Mafrooq  && noc == Conjugation.Second);
    }
}
