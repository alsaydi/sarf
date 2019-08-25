package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;

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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (يَتَناسَى، يَتَرَقَّى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يَتَناسَى، يَتَرَقَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَناسَ، يَتَرَقَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَناسَيْنَ، تَتَرَقَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَناسَوْنَ، تَتَرَقَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَناسَوُنَّ، تَتَرَقَّوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) && (formulaNo == 7 || formulaNo == 8);
    }
}
