package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;
import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.ArrayList;
import java.util.List;

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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public YaeiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي")); // EX: (هذا المُهْدِي، )
        substitutions.add(new SuffixSubstitution("ِيَ", "ِيَ")); // EX: (رأيتُ المُهْدِيَ، )
        substitutions.add(new SuffixSubstitution("ِيِ", "ِي")); // EX: (مررتُ على المُهْدِي ، )
        substitutions.add(new InfixSubstitution("ِيٌ", "ٍ")); // EX: (هذا مُهْدٍ)
        substitutions.add(new InfixSubstitution("ِيٍ", "ٍ")); // EX: (مررتُ على مُهْدٍ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (مُهْدُونَ، )
        substitutions.add(new InfixSubstitution("ِيِ", "ِ")); // EX: (مُهْدِينَ، )
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        if (triAugmentedConjugationResult.getRoot().getC3() != 'ي')
            return false;

        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
            switch (formulaNo) {
                case 4:
                case 11:
                    return true;
            }
            return formulaNo == 10;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 11:
                    return true;
            }
            return formulaNo == 10;
        } else if (kov == KindOfVerb.Naqis_Yaee) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
            switch (formulaNo) {
                case 3:
                case 4:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
