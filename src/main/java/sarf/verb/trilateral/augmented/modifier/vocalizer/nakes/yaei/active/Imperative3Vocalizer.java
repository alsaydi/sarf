package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (رَقِّ، اجْأوِّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ رَقِّي، اجْأوِّي)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ رَقِّنَّ، اجْأوِّنَّ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن رَقِّينَ، اجْأوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم رَقُّوا، اجْأوُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) && formulaNo == 2) || (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain && (formulaNo == 2 || formulaNo == 11));
    }
}
