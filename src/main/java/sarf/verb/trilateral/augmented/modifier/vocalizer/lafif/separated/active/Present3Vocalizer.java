package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;
import sarf.verb.trilateral.augmented.modifier.*;

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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي"));// EX: (يُوَصِّي)
        substitutions.add(new SuffixSubstitution("يْ", ""));// EX: (لم يُوَصِّ)
        substitutions.add(new InfixSubstitution("يِن", "ن"));// EX: (أنتِ تُوَصِّنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي"));// EX: (أنتِ تُوَصِّينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين"));// EX: (أنتن تُوَصِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُو", "ُّو"));// EX: (أنتم تُوَصُّونَ)
        substitutions.add(new InfixSubstitution("ِّيُن", "ُّن"));// EX: (أنتم تُوَصُّنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Lafeef_Mafrooq  && formulaNo == 2);
    }
}
