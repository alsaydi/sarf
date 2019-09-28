package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.ConjugationResult;

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
public class ActivePresent1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresent1Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("َيْC2ِيُ","َC2ِي"));// EX: (يَدِي)
        substitutions.add(new ExpressionSuffixSubstitution("َيْC2ِيْ","َC2ِ"));// EX: (لم يَدِ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيِن","َC2ِن"));// EX: (أنتِ تَدِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيِ","َC2ِ"));// EX: (أنتِ تَدِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيْ","َC2ِي"));// EX: (أنتن تَدِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيُ","َC2ُ"));// EX: (أنتم تَدُونَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيَ","َC2ِيَ"));// EX: (أنتما تَدِيان)
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
