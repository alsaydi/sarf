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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("اوْC2ِيْ", "C2ِ")); // EX: (قِ، لِ)
        substitutions.add(new ExpressionInfixSubstitution("اوْC2ِيِ","C2ِ"));// EX: (أنتِ قِي، لِي)
        substitutions.add(new ExpressionInfixSubstitution("اوْC2ِيْ", "C2ِي")); // EX: (أنتن قِينَ، لِينَ)
        substitutions.add(new ExpressionInfixSubstitution("اوْC2ِيُ", "C2ُ")); // EX: (أنتم قُوا، لُوا)
        substitutions.add(new ExpressionInfixSubstitution("اوْC2ِيَ", "C2ِيَ")); // EX: (أنتما قِيا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq ) && (noc == Conjugation.Second)) ||
                (kov == KindOfVerb.Lafeef_Mafrooq  && noc == Conjugation.Sixth);
    }
}
