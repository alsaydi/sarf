package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (وَصِّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ وَصِّي)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ وَصِّنَّ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن وَصِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم وَصُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Lafeef_Mafrooq  && formulaNo == 2);
    }
}
