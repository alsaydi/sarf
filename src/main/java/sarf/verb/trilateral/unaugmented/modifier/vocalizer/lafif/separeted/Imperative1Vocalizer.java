package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
    private List<Substitution> substitutions = new ArrayList<>();

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
        return (conjugationResult.getRoot().getC1()=='ي' && kov == 30 && noc == Conjugation.Second);
    }
}
