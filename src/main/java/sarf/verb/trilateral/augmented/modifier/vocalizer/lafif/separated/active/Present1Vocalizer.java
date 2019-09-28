package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُوصِي، يوالِي، يَتَّقِي، يستوفِي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُوصِ، يوالِ، يَتَّقِ، يستوفِ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُوصِنَّ، توالِنَّ، تَتَّقِنَّ، تستوفِنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُوصِينَ، تُوالِينَ، تَتَّقِينَ، تَستوفِينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُوصِينَ، تُوالِينَ، تَتَّقِينَ، تَستوفِينَ)
        substitutions.add(new InfixSubstitution("ِيُو", "ُو")); // EX: (أنتم تُوصُونَ، تُوالُونَ، تَتَّقُونَ، تَستوفُونَ)
        substitutions.add(new InfixSubstitution("ِيُن", "ُن")); // EX: (أنتم تُوصُنَّ، تُوالُنَّ، تَتَّقُنَّ، تَستوفُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;
    }
}
